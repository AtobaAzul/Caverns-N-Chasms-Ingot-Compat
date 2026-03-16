with open("supported_ingots.txt", "r") as file:
    for line in file:
        mod = line.split(":")[0] # e.g. immersiveengineering
        ingot = line.split(":")[1].strip() # e.g. ingot_electrum, zinc_ingot

        new_file = open("blocks/"+mod + "_" + ingot + ".json", "w")


        text = '''{{
  "type": "minecraft:block",
  "pools": [
    {{
      "bonus_rolls": 0.0,
      "conditions": [
        {{
          "condition": "minecraft:inverted",
          "term": {{
            "block": "cc_compat:{mod}_{ingot}",
            "condition": "minecraft:block_state_property",
            "properties": {{
              "layers": "0"
            }}
          }}
        }}
      ],
      "entries": [
        {{
          "type": "cc_compat:optional_item",
          "functions": [
            {{
              "add": false,
              "conditions": [
                {{
                  "block": "cc_compat:{mod}_{ingot}",
                  "condition": "minecraft:block_state_property",
                  "properties": {{
                    "layers": "1"
                  }}
                }}
              ],
              "count": 2.0,
              "function": "minecraft:set_count"
            }},
            {{
              "add": false,
              "conditions": [
                {{
                  "block": "cc_compat:{mod}_{ingot}",
                  "condition": "minecraft:block_state_property",
                  "properties": {{
                    "layers": "2"
                  }}
                }}
              ],
              "count": 4.0,
              "function": "minecraft:set_count"
            }},
            {{
              "add": false,
              "conditions": [
                {{
                  "block": "cc_compat:{mod}_{ingot}",
                  "condition": "minecraft:block_state_property",
                  "properties": {{
                    "layers": "3"
                  }}
                }}
              ],
              "count": 6.0,
              "function": "minecraft:set_count"
            }},
            {{
              "function": "minecraft:explosion_decay"
            }}
          ],
          "name": "{mod}:{ingot}"
        }}
      ],
      "rolls": 1.0
    }},
    {{
      "bonus_rolls": 0.0,
      "entries": [
        {{
          "type": "cc_compat:optional_item",
          "functions": [
            {{
              "add": false,
              "conditions": [
                {{
                  "block": "cc_compat:{mod}_{ingot}",
                  "condition": "minecraft:block_state_property",
                  "properties": {{
                    "top_ingot": "both"
                  }}
                }}
              ],
              "count": 2.0,
              "function": "minecraft:set_count"
            }},
            {{
              "function": "minecraft:explosion_decay"
            }}
          ],
          "name": "{mod}:{ingot}"
        }}
      ],
      "rolls": 1.0
    }}
  ],
  "random_sequence": "cc_compat:blocks/{mod}_{ingot}"
}}
'''
        text = text.format(mod=mod, ingot=ingot)

        new_file.writelines(text)
        print("Created loot table file: " + mod + "_" + ingot + ".json")
        new_file.close()
        

