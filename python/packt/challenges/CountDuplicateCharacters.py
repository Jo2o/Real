import collections

print(collections.Counter("hello").items())

# ----------------------------------

count = {}
for ch in "hello":
    if ch in count:
        count[ch] += 1
    else:
        count[ch] = 1

for k in count:
    if count[k] > 1:
        print(f"{k}: {count[k]}")

# ---------------------------------

mapping = {}
for ch in "iterable":
    mapping[ch] = mapping.get(ch, 0) + 1
print(mapping)