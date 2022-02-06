import pandas as p

data = {
    "city": ["Trencin", "Lucenec"],
    "citizens": [3000, 500]
}

data_frame = p.DataFrame(data)
print("Whole DataFrame:")
print("----------------")
print(data_frame)


