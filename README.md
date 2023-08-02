## Permissions

Les permissions sont sous la forme `lalambic.<action>.<potion>`, où `<action>` correspond
à une des actions suivantes :

|    Action    | Description                                                                   |
|:------------:|:------------------------------------------------------------------------------|
|    `brew`    | Créer une potion fondamentale.                                                |
|  `lengthen`  | Allonger une potion fondamentale (poudre de redstone).                        |
| `strengthen` | Renforcer une potion fondamentale (poudre lumineuse).                         |
|   `splash`   | Transformer une potion fondamentale en une potion jetable (poudre à canon).   |
|   `linger`   | Transformer une potion jetable en une potion persistante (souffle du dragon). |

Et où `<potion>` correspond à une des potions de la table ci-dessous.

## Liste des potions

|      Potion       | Allongeable | Renforçable |
|:-----------------:|:-----------:|:-----------:|
|     `mundane`     |   &cross;   |   &cross;   |
|      `thick`      |   &cross;   |   &cross;   |
|     `awkward`     |   &cross;   |   &cross;   |
|  `night_vision`   |   &check;   |   &cross;   |
|  `invisibility`   |   &check;   |   &cross;   |
|      `jump`       |   &check;   |   &check;   |
| `fire_resistance` |   &check;   |   &cross;   |
|      `speed`      |   &check;   |   &check;   |
|    `slowness`     |   &check;   |   &check;   |
| `water_breathing` |   &check;   |   &cross;   |
|  `instant_heal`   |   &cross;   |   &check;   |
| `instant_damage`  |   &cross;   |   &check;   |
|     `poison`      |   &check;   |   &check;   |
|      `regen`      |   &check;   |   &check;   |
|    `strength`     |   &check;   |   &check;   |
|    `weakness`     |   &check;   |   &check;   |
|  `turtle_master`  |   &check;   |   &check;   |
|  `slow_falling`   |   &check;   |   &check;   |

## Example

Pour créer entièrement une potion de force II persistante, le joueur devra avoir les
permissions suivantes :
- `lalambic.brew.awkward`
- `lalambic.brew.strength`
- `lalambic.strengthen.strength`
- `lalambic.splash.strength`
- `lalambic.linger.strength`
