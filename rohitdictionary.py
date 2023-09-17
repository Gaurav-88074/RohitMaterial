d = {
    "boys"  : [72,68,70,69,74],
    "girls" : [63,65,69,62,61]
}
res = []
for b,g in zip(d["boys"],d["girls"]):
    res.append({
        "Boys" : b,
        "Girls":g
    })
print(res)