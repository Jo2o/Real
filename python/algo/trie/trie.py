class Trie:
    def __init__(self):
        self.child = {}   # using dictionaries within dictionaries and keys are letters

    def insert(self, word):
        current = self.child
        for letter in word:
            if letter not in current:
                current[letter] = {}
            current = current[letter]
        current['#'] = 1

    def search(self, word):
        current = self.child
        for letter in word:
            if letter not in current:
                return False
            current = current[letter]
        return '#' in current

    def starts_with(self, prefix):
        current = self.child
        for letter in prefix:
            if letter not in current:
                return False
            current = current[letter]
        return True


tr = Trie()

tr.insert("apple")
print(tr.search("apple"))
print(tr.search("app"))
print(tr.starts_with("app"))

tr.insert("app")
print(tr.search("app"))
