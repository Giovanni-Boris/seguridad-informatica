# -*- coding: utf-8 -*-
"""Untitled5.ipynb

Automatically generated by Colab.

Original file is located at
    https://colab.research.google.com/drive/195JmOF5WPnDjEsTgLVFZfe7td6gkNDjc

# Análisis de Frecuencia de Caracteres
"""

from collections import Counter

cipher_text = "MAXYHGAVAPUUGZHEGZQOWOBNIPQKRNÑMEXIGONIICUCAWIGCTEAGMNOLRSZJNLWÑAWWIGLDDZSNIZDNBIXGZLAYMXÑCVEKIETMOEOPBEWPTNIXCXUIHMECXLNOCECYXEQPBWUFANIICÑJIKISCZUAILBGSOANKBFWUAYWNSCHLCWYDZHDZAQVMPTVGFGPVAJWFVPUOYMXCWERVLQCZWECIFVITUZSNCZUAIKBFMÑALIEGLBSZLQUXÑOHWOCGHNYWÑQKDANZUDIFOIMXNPHNUWQOKLMVBNNKRMKONDPDPNMIKAWOXMEEIVEKGBGSFHVADWPGOYMHOIUEEIPGOLENZBSCHAGKQTZDRÑMÑNWTUZIÑCMÑAXKQUWDLVANNIHLÑCQNWGEHIPGZDTZTÑNWÑEEWFUMGIÑXNTWXNVIXCZOAZSOQUVENDNFWUSZYHGLRACPGGUGIYWHOTRMZUGQQDDZIZFWHVVSHCUGOGIFKBXAXPBOBRDVDUCMVTKGIKDRSZLUQSDVPMXVIVEYMFGTEANIMQLHLGPQOHRYWCFEWFOISNÑPUAYINNÑXNÑPGKWGOILQGAFOILQTAHEIIDWMÑEÑXNEPRCVDQTURSK"

char_freq = Counter(cipher_text)
char_freq = dict(sorted(char_freq.items(), key=lambda item: item[1], reverse=True))
char_freq

"""#Kasiski Examination (para cifrado Vigenère)"""

def find_repeated_sequences(text, seq_len):
    seq_positions = {}
    for i in range(len(text) - seq_len + 1):
        seq = text[i:i + seq_len]
        if seq in seq_positions:
            seq_positions[seq].append(i)
        else:
            seq_positions[seq] = [i]
    return {seq: pos for seq, pos in seq_positions.items() if len(pos) > 1}

repeated_sequences = find_repeated_sequences(cipher_text, 3)
repeated_sequences

"""# Determinar la Longitud de la Clave"""

from math import gcd
from functools import reduce

distances = []
for seq, positions in repeated_sequences.items():
    for i in range(len(positions) - 1):
        distances.append(positions[i+1] - positions[i])

# Encontrar el máximo común divisor de las distancias
key_length = reduce(gcd, distances)
key_length

"""#Desencriptar Usando la Longitud de la Clave"""

# Suponiendo que hemos determinado la longitud de la clave (key_length)
segments = [''.join([cipher_text[i] for i in range(j, len(cipher_text), key_length)]) for j in range(key_length)]

# Analizar la frecuencia de cada segmento
segment_freqs = [Counter(segment) for segment in segments]
segment_freqs

"""# Determinar la Clave y el Texto en Claro"""

# Frecuencias aproximadas de las letras en español
spanish_freq = {
    'A': 12.53, 'B': 1.42, 'C': 4.68, 'D': 5.86, 'E': 13.68, 'F': 0.69, 'G': 1.01,
    'H': 0.70, 'I': 6.25, 'J': 0.44, 'K': 0.02, 'L': 4.97, 'M': 3.15, 'N': 6.71,
    'Ñ': 0.31, 'O': 8.68, 'P': 2.51, 'Q': 0.88, 'R': 6.87, 'S': 7.98, 'T': 4.63,
    'U': 3.93, 'V': 0.90, 'W': 0.01, 'X': 0.22, 'Y': 0.90, 'Z': 0.52
}

import numpy as np
from collections import Counter

# Frecuencias aproximadas de las letras en español, incluyendo 'Ñ'
spanish_freq = {
    'A': 12.53, 'B': 1.42, 'C': 4.68, 'D': 5.86, 'E': 13.68, 'F': 0.69, 'G': 1.01,
    'H': 0.70, 'I': 6.25, 'J': 0.44, 'K': 0.02, 'L': 4.97, 'M': 3.15, 'N': 6.71,
    'Ñ': 0.31, 'O': 8.68, 'P': 2.51, 'Q': 0.88, 'R': 6.87, 'S': 7.98, 'T': 4.63,
    'U': 3.93, 'V': 0.90, 'W': 0.01, 'X': 0.22, 'Y': 0.90, 'Z': 0.52
}

# Función para correlacionar las frecuencias de un segmento con las esperadas en español
def correlate_frequencies(segment, spanish_freq):
    segment_len = len(segment)
    segment_freq = Counter(segment)
    segment_freq = {char: count/segment_len for char, count in segment_freq.items()}
    alphabet = list(spanish_freq.keys())
    segment_freq_vector = np.array([segment_freq.get(char, 0) for char in alphabet])
    spanish_freq_vector = np.array([spanish_freq[char] for char in alphabet])
    correlations = []
    for shift in range(27):
        rotated_spanish_freq = np.roll(spanish_freq_vector, shift)
        correlation = np.dot(segment_freq_vector, rotated_spanish_freq)
        correlations.append(correlation)
    best_shift = np.argmax(correlations)
    return best_shift

# Suponiendo que `segments` es una lista de segmentos del texto cifrado según la longitud de la clave
# Asegurarse de que `segments` se ha generado previamente
segments = [''.join([cipher_text[i] for i in range(j, len(cipher_text), key_length)]) for j in range(key_length)]

# Determinar los desplazamientos de la clave
key_shifts = [correlate_frequencies(segment, spanish_freq) for segment in segments]
key = ''.join(chr(shift + 65) if shift != 14 else 'Ñ' for shift in key_shifts)
key

def decrypt_vigenere(cipher_text, key):
    mod = 27
    decrypted_text = ""
    key_len = len(key)
    key_indices = [ord(k) - 65 if k != 'Ñ' else 14 for k in key]

    for i, char in enumerate(cipher_text):
        if char == 'Ñ':
            char_index = 14  # Índice para ñ en alfabeto mod 27
        else:
            char_index = ord(char) - 65
        key_index = key_indices[i % key_len]
        decrypted_index = (char_index - key_index) % mod
        if decrypted_index == 14:
            decrypted_char = 'Ñ'
        else:
            decrypted_char = chr(decrypted_index + 65)
        decrypted_text += decrypted_char

    return decrypted_text

decrypted_text = decrypt_vigenere(cipher_text, key)
clean_decrypted_text = ''.join(char for char in decrypted_text if char.isalpha() or char == ' ')
print(clean_decrypted_text)