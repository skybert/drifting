import yaml


y = """
happy: Yes
"""

yam = yaml.load(y)

print(type(yam["happy"]))
