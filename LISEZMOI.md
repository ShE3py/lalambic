## Permissions

Les permissions sont sous la forme `lalambic.<action>.<potion>`, où `<action>` correspond
à une des actions suivantes :

|    Action    | Description                                                                   |
|:------------:|:------------------------------------------------------------------------------|
|    `brew`    | Créer une potion fondamentale.                                                |
|  `lengthen`  | Allonger une potion (poudre de redstone).                                     |
| `strengthen` | Renforcer une potion (poudre lumineuse).                                      |
|   `splash`   | Transformer une potion en une potion jetable (poudre à canon).                |
|   `linger`   | Transformer une potion jetable en une potion persistante (souffle du dragon). |

Et où `<potion>` correspond à une des potions de la table ci-dessous.

## Liste des potions

|      Potion       | Allongeable | Renforçable |
|:-----------------:|:-----------:|:-----------:|
|     `mundane`     |             |             |
|      `thick`      |             |             |
|     `awkward`     |             |             |
|  `night_vision`   |   &check;   |             |
|  `invisibility`   |   &check;   |             |
|      `jump`       |   &check;   |   &check;   |
| `fire_resistance` |   &check;   |             |
|      `speed`      |   &check;   |   &check;   |
|    `slowness`     |   &check;   |   &check;   |
| `water_breathing` |   &check;   |             |
|  `instant_heal`   |             |   &check;   |
| `instant_damage`  |             |   &check;   |
|     `poison`      |   &check;   |   &check;   |
|      `regen`      |   &check;   |   &check;   |
|    `strength`     |   &check;   |   &check;   |
|    `weakness`     |   &check;   |   &check;   |
|  `turtle_master`  |   &check;   |   &check;   |
|  `slow_falling`   |   &check;   |   &check;   |

## Exemple

Pour créer entièrement une potion de force II persistante, le joueur devra avoir les
permissions suivantes :
- `lalambic.brew.awkward`
- `lalambic.brew.strength`
- `lalambic.strengthen.strength`
- `lalambic.splash.strength`
- `lalambic.linger.strength`

## Remarque

Les entonnoirs peuvent être utilisés pour outrepasser ce système de permissions.
