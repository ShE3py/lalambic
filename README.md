# Lalambic

[Version française](LISEZMOI.md)

## Permissions

Permissions are in the format `lalambic.<action>.<potion>`, where `<action>` is one of
the following actions:

|    Action    | Description                                                     |
|:------------:|:----------------------------------------------------------------|
|    `brew`    | Create a fundamental potion.                                    |
|  `lengthen`  | Lengthen a potion (redstone dust).                              |
| `strengthen` | Strengthen a potion (glowstone dust).                           |
|   `splash`   | Turn a potion into a splash potion (gunpowder).                 |
|   `linger`   | Turn a splash potion into a lingering potion (dragon's breath). |

And where `<potion>` is one of the potions in the following list.

## Potion list

|      Potion       | Lengthenable | Strengthenable |
|:-----------------:|:------------:|:--------------:|
|     `mundane`     |              |                |
|      `thick`      |              |                |
|     `awkward`     |              |                |
|  `night_vision`   |   &check;    |                |
|  `invisibility`   |   &check;    |                |
|      `jump`       |   &check;    |    &check;     |
| `fire_resistance` |   &check;    |                |
|      `speed`      |   &check;    |    &check;     |
|    `slowness`     |   &check;    |    &check;     |
| `water_breathing` |   &check;    |                |
|  `instant_heal`   |              |    &check;     |
| `instant_damage`  |              |    &check;     |
|     `poison`      |   &check;    |    &check;     |
|      `regen`      |   &check;    |    &check;     |
|    `strength`     |   &check;    |    &check;     |
|    `weakness`     |   &check;    |    &check;     |
|  `turtle_master`  |   &check;    |    &check;     |
|  `slow_falling`   |   &check;    |    &check;     |

## Example

To fully create a lingering Strength II potion, the player will need the following
permissions:

- `lalambic.brew.awkward`
- `lalambic.brew.strength`
- `lalambic.strengthen.strength`
- `lalambic.splash.strength`
- `lalambic.linger.strength`

## Remark

Hoppers may be used to bypass this permission system.
