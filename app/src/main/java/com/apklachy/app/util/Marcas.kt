package com.apklachy.app.util

object Marcas {

    private fun linea(marca: String, vararg modelos: String): List<String> =
        modelos.map { modelo -> "$marca $modelo".trim() }

    val TODAS: List<String> = (
        linea(
            "Samsung",
            "A01", "A02", "A02s", "A03", "A03s", "A03 Core", "A04", "A04s", "A04e",
            "A05", "A05s", "A06", "A06s",
            "A10", "A10s", "A10e", "A11", "A12", "A13", "A14", "A15", "A16",
            "A20", "A20s", "A21", "A21s", "A22", "A23", "A24", "A25", "A26",
            "A30", "A30s", "A31", "A32", "A33", "A34", "A35", "A36",
            "A50", "A50s", "A51", "A52", "A52s", "A53", "A54", "A55", "A56",
            "A70", "A71", "A72", "A73",
            "J1", "J2", "J3", "J3 Pro", "J4", "J4+", "J5", "J5 Neo", "J6", "J6+",
            "J7", "J7 Neo", "J7+", "J8",
            "M10", "M10s", "M11", "M12", "M13", "M14", "M15",
            "M20", "M21", "M21s", "M22", "M23", "M26",
            "M30", "M30s", "M31", "M31s", "M32", "M33", "M34", "M35",
            "M51", "M52", "M53", "M55", "M62",
            "S8", "S8+", "S9", "S9+", "S10", "S10e", "S10+",
            "S20", "S20 FE", "S21", "S21 FE", "S22", "S22 Ultra",
            "S23", "S23 FE", "S23 Ultra", "S24", "S24 FE", "S24 Ultra",
            "S25", "S25 Ultra",
            "Note 8", "Note 9", "Note 10", "Note 10+", "Note 20", "Note 20 Ultra",
            "Z Flip3", "Z Flip4", "Z Flip5", "Z Flip6",
            "Z Fold3", "Z Fold4", "Z Fold5", "Z Fold6",
            "XCover4s", "XCover5", "XCover Pro",
            "Core Prime", "Grand Prime", "Star", "Grand", "On5", "On7", "Trend", "Ace"
        ) +
            linea(
                "Xiaomi",
                "Redmi A1", "Redmi A1 Plus", "Redmi A2", "Redmi A2 Plus",
                "Redmi A3", "Redmi A3 Pro", "Redmi A4", "Redmi A5",
                "Redmi 9", "Redmi 9A", "Redmi 9C", "Redmi 9C NFC", "Redmi 9T", "Redmi 9 Power",
                "Redmi 10", "Redmi 10C", "Redmi 10S", "Redmi 12", "Redmi 12C",
                "Redmi 13", "Redmi 13C", "Redmi 13R", "Redmi 14", "Redmi 14C",
                "Redmi Note 7", "Redmi Note 8", "Redmi Note 8T", "Redmi Note 8 Pro",
                "Redmi Note 9", "Redmi Note 9C", "Redmi Note 9S", "Redmi Note 9 Pro", "Redmi Note 9T",
                "Redmi Note 10", "Redmi Note 10S", "Redmi Note 10 Pro",
                "Redmi Note 11", "Redmi Note 11S", "Redmi Note 11T", "Redmi Note 11 Pro", "Redmi Note 11 SE",
                "Redmi Note 12", "Redmi Note 12 4G", "Redmi Note 12 5G", "Redmi Note 12S", "Redmi Note 12 Pro",
                "Redmi Note 13", "Redmi Note 13 4G", "Redmi Note 13 5G", "Redmi Note 13 Pro", "Redmi Note 13R",
                "Redmi Note 14", "Redmi Note 14 5G", "Redmi Note 14 Pro",
                "Xiaomi 11 Lite", "Xiaomi 11T", "Xiaomi 11T Pro",
                "Xiaomi 12", "Xiaomi 12 Lite", "Xiaomi 12T", "Xiaomi 12T Pro",
                "Xiaomi 13", "Xiaomi 13 Pro", "Xiaomi 13T", "Xiaomi 13T Pro",
                "Xiaomi 14", "Xiaomi 14 Pro", "Xiaomi 14T",
                "Xiaomi 15", "Xiaomi 15 Ultra",
                "Poco C55", "Poco C61", "Poco C65", "Poco C75",
                "Poco M3", "Poco M4 Pro", "Poco M5", "Poco M5s", "Poco M6", "Poco M6 Pro", "Poco M7",
                "Poco X3", "Poco X3 NFC", "Poco X3 Pro",
                "Poco X4 Pro", "Poco X5", "Poco X5 Pro", "Poco X6", "Poco X6 Pro", "Poco X7", "Poco X7 Pro",
                "Poco F3", "Poco F5", "Poco F6"
            ) +
            linea(
                "Motorola",
                "Moto E5", "Moto E5 Play", "Moto E5 Go", "Moto E6", "Moto E6 Play", "Moto E6i",
                "Moto E7", "Moto E7i", "Moto E7 Plus", "Moto E8", "Moto E13", "Moto E20",
                "Moto E22", "Moto E22s", "Moto E30", "Moto E32", "Moto E32s", "Moto E33", "Moto E40",
                "Moto G5", "Moto G5 Plus", "Moto G5S", "Moto G5S Plus",
                "Moto G6", "Moto G6 Play", "Moto G6 Plus",
                "Moto G7", "Moto G7 Play", "Moto G7 Plus", "Moto G7 Power", "Moto G7 One",
                "Moto G8", "Moto G8 Play", "Moto G8 Plus", "Moto G8 Power", "Moto G8 Power Lite",
                "Moto G9", "Moto G9 Play", "Moto G9 Plus", "Moto G9 Power",
                "Moto G10", "Moto G10 Power", "Moto G20", "Moto G22", "Moto G23", "Moto G24", "Moto G24 Power",
                "Moto G30", "Moto G31", "Moto G32", "Moto G33", "Moto G34", "Moto G41", "Moto G42", "Moto G45",
                "Moto G50", "Moto G51", "Moto G52", "Moto G53", "Moto G53s", "Moto G54", "Moto G55",
                "Moto G60", "Moto G60s", "Moto G62", "Moto G71", "Moto G72", "Moto G73",
                "Moto G82", "Moto G84", "Moto G85",
                "Moto G100", "Moto G200",
                "Edge 20", "Edge 30", "Edge 30 Fusion", "Edge 30 Neo", "Edge 30 Ultra",
                "Edge 40", "Edge 40 Neo", "Edge 50", "Edge 50 Fusion",
                "Razr 40", "Razr 40 Ultra"
            ) +
            linea(
                "Huawei",
                "Y5 2017", "Y5 2018", "Y5 2019", "Y5 Prime",
                "Y6 2018", "Y6 2019", "Y6 Pro", "Y6 Prime", "Y6s",
                "Y7 2019", "Y7a", "Y7 Prime", "Y7s", "Y7p",
                "Y8s", "Y9 2019", "Y9a", "Y9 Prime", "Y9s",
                "Nova 5T", "Nova 7i", "Nova 8i", "Nova 9", "Nova 9 SE", "Nova 10", "Nova 10 SE", "Nova 11", "Nova 11i",
                "P20 Lite", "P30 Lite", "P40 Lite", "P40 Lite 5G", "P50", "P50 Pocket", "P60",
                "Mate 20 Lite", "Mate 30 Lite", "Mate 40 Pro", "Mate 50",
                "Enjoy 10", "Enjoy 10s", "Enjoy 20", "Enjoy 20 Pro"
            ) +
            linea(
                "Honor",
                "7S", "7A", "8A", "8C", "8S", "8X",
                "9A", "9S", "9X", "9X Lite", "10", "20", "30",
                "X6", "X7", "X7a", "X8", "X8a", "X8 Lite", "X9", "X9a", "X9b", "X9c",
                "Magic 4 Lite", "Magic 5 Lite", "Magic 6 Lite",
                "Play 5T", "Play 6T", "Play 7T", "Play 8A",
                "View 30", "View 40"
            ) +
            linea(
                "Oppo",
                "A1", "A1k", "A3", "A3s", "A5", "A5 2020", "A5s", "A7", "A7n", "A9", "A9 2020",
                "A91", "A92", "A93", "A94", "A95", "A96", "A98",
                "A15", "A15s", "A16", "A16e", "A16s", "A17", "A18",
                "A38", "A53", "A54", "A55", "A56", "A57", "A58",
                "A74", "A76", "A77", "A78", "A80", "A90",
                "Reno 4", "Reno 4F", "Reno 5", "Reno 5F", "Reno 6", "Reno 6Z",
                "Reno 7", "Reno 7Z", "Reno 8", "Reno 8T", "Reno 9", "Reno 10", "Reno 11", "Reno 12",
                "Find X2", "Find X3", "Find X5", "Find X6", "Find X7",
                "F1s", "F3", "F5", "F7", "F9", "F11", "F17", "F19", "F21s", "F23"
            ) +
            linea(
                "Vivo",
                "Y1", "Y1s", "Y11", "Y12", "Y12s", "Y15", "Y15s", "Y17",
                "Y20", "Y20s", "Y21", "Y21t", "Y22", "Y22s",
                "Y30", "Y33", "Y33s", "Y35", "Y36",
                "Y50", "Y51", "Y53s", "Y55", "Y55s", "Y70", "Y72", "Y75", "Y76", "Y78",
                "Y80", "Y85", "Y91", "Y93", "Y95", "Y97",
                "V9", "V11", "V15", "V17", "V19", "V20", "V21", "V21e",
                "V23", "V23e", "V25", "V25e", "V27", "V27e", "V29", "V29e", "V30", "V30e",
                "X50", "X50 Lite", "X60", "X70", "X80", "X90", "X100"
            ) +
            linea(
                "Realme",
                "C11", "C12", "C15", "C17", "C21", "C21e", "C25", "C25s", "C25Y",
                "C30", "C30s", "C31", "C33", "C35", "C51", "C53", "C55", "C67", "C71",
                "Narzo 30A", "Narzo 50", "Narzo 50A", "Narzo 50i", "Narzo 50 Prime", "Narzo 60", "Narzo 70",
                "3", "3 Pro", "5", "5 Pro", "6", "6 Pro", "7", "7 Pro",
                "8", "8 5G", "8 Pro", "9", "9 5G", "9 Pro", "10", "10 Pro",
                "11", "11 5G", "11 Pro", "12", "12 Pro", "12X",
                "GT Master", "GT Neo2", "GT 2", "GT 2 Pro", "GT 3", "GT 5", "GT 6"
            ) +
            linea(
                "Nokia",
                "1", "1.3", "1.4", "2", "2.3", "2.4", "3", "3.1", "3.2", "3.4",
                "5", "5.1", "5.3", "5.4", "6", "6.1", "6.2", "7", "7.2", "8", "8.1",
                "C1", "C1 Plus", "C2", "C2 2nd", "C5", "C5 Endi",
                "C10", "C11", "C12", "C20", "C20 Plus", "C21", "C21 Plus", "C22",
                "C30", "C31", "C32", "C51", "C52",
                "G10", "G20", "G21", "G30", "G40", "G50", "G60", "G100", "G110", "G200",
                "X10", "X20", "XR20", "XR21", "XR30", "X30",
                "110", "105", "106", "8110", "3310", "5310", "8000", "2660"
            ) +
            linea(
                "Tecno",
                "Spark 5", "Spark 5 Air", "Spark 6", "Spark 6 Air",
                "Spark 7", "Spark 7 Pro", "Spark 8", "Spark 8 Pro", "Spark 8C",
                "Spark 9", "Spark 9T", "Spark 10", "Spark 10C", "Spark 10 Pro",
                "Spark 20", "Spark 20 Pro", "Spark 20C", "Spark 30", "Spark Go",
                "Pop 4", "Pop 5", "Pop 5 LTE", "Pop 6", "Pop 6 Pro", "Pop 7", "Pop 7 Pro", "Pop 8", "Pop 9",
                "Camon 15", "Camon 15 Pro", "Camon 16", "Camon 16 Pro",
                "Camon 17", "Camon 17 Pro", "Camon 18", "Camon 18 Pro",
                "Camon 19", "Camon 19 Pro", "Camon 20", "Camon 20 Pro",
                "Camon 21", "Camon 21 Pro", "Camon 22", "Camon 22 Pro",
                "Camon 23", "Camon 23 Pro", "Camon 24", "Camon 30",
                "Pova", "Pova 2", "Pova 3", "Pova 4", "Pova 4 Pro", "Pova 5", "Pova 5 Pro", "Pova 6",
                "Note 30", "Note 30 5G", "Note 40",
                "Phantom V Fold", "Phantom V Flip"
            ) +
            linea(
                "Infinix",
                "Hot 7", "Hot 7 Pro", "Hot 8", "Hot 8 Lite",
                "Hot 9", "Hot 9 Play", "Hot 10", "Hot 10 Play", "Hot 10S",
                "Hot 11", "Hot 11 Play", "Hot 11S", "Hot 12", "Hot 12 Play", "Hot 12i",
                "Hot 13", "Hot 30", "Hot 30i", "Hot 40", "Hot 40i", "Hot 50",
                "Note 7", "Note 7 Lite", "Note 8", "Note 8i",
                "Note 10", "Note 10 Pro", "Note 11", "Note 11 Pro", "Note 11S",
                "Note 12", "Note 12 4G", "Note 12 Pro", "Note 12 Pro 5G",
                "Note 13", "Note 13 4G", "Note 13 Pro",
                "Note 30", "Note 30 5G", "Note 40",
                "Smart 4", "Smart 5", "Smart 6", "Smart 6 Plus", "Smart 7", "Smart 8", "Smart 8 Pro",
                "Zero 8", "Zero 5G", "Zero X", "Zero 30", "Zero 40"
            ) +
            linea(
                "Itel",
                "A14", "A16", "A23", "A23 Pro", "A25", "A25 Pro", "A27", "A28", "A29",
                "A33", "A35", "A36", "A37", "A38", "A40", "A44", "A44 Max", "A46", "A48", "A49",
                "A49 Max", "A50", "A55", "A56", "A58", "A60", "A60s", "A66", "A66s", "A70", "A70s", "A80",
                "P15", "P32", "P33", "P33 Plus", "P36", "P40", "P40 Pro", "P55", "P55 Plus",
                "Vision 1", "Vision 1 Plus", "Vision 2", "Vision 3", "Vision 3 Plus",
                "Vision 5", "Vision 5 Plus", "Vision 7",
                "S15", "S16", "S17", "S18", "S18 Pro", "S19", "S19 Pro", "S23", "S24"
            ) +
            linea(
                "ZTE",
                "Blade A3", "Blade A3 Lite", "Blade A5", "Blade A5 Lite", "Blade A5 2020", "Blade A5 2022",
                "Blade A7", "Blade A7 2020", "Blade A7 2022", "Blade A7 2024",
                "Blade A31", "Blade A32", "Blade A51", "Blade A52", "Blade A53", "Blade A54", "Blade A55",
                "Blade A71", "Blade A72", "Blade A73", "Blade A76",
                "V20", "V21", "V40", "V40 Pro", "V41", "V50", "V50 Pro", "V60", "V60 Pro",
                "Libera 5G", "Libera N95",
                "Axon 11", "Axon 20", "Axon 30", "Axon 40", "Axon 50",
                "Quest", "Max", "Small Flip"
            ) +
            linea(
                "LG",
                "K7", "K8", "K9", "K10", "K11", "K12", "K13",
                "K20", "K21", "K22", "K23", "K30", "K31", "K32", "K40", "K41", "K42", "K43",
                "K50", "K51", "K52", "K53", "K61", "K62", "K71", "K92", "K12+",
                "Q6", "Q6 Plus", "Q6 Alpha", "Q7", "Q7 Plus", "Q8", "Q8 Plus", "Q9",
                "Stylo 4", "Stylo 5", "Stylo 6", "Stylo 7", "Stylo 8",
                "G2", "G3", "G4", "G5", "G6", "G7", "G8", "G8X", "Velvet", "Wing",
                "Phoenix", "Premier", "Harmony", "Journey"
            ) +
            linea(
                "iPhone",
                "6", "6 Plus", "6s", "6s Plus",
                "7", "7 Plus", "8", "8 Plus", "SE 2020", "SE 2022", "SE 3",
                "X", "XR", "XS", "XS Max",
                "11", "11 Pro", "11 Pro Max",
                "12", "12 Mini", "12 Pro", "12 Pro Max",
                "13", "13 Mini", "13 Pro", "13 Pro Max",
                "14", "14 Plus", "14 Pro", "14 Pro Max",
                "15", "15 Plus", "15 Pro", "15 Pro Max",
                "16", "16 Plus", "16 Pro", "16 Pro Max"
            ) +
            linea(
                "Google",
                "Pixel 3", "Pixel 3 XL", "Pixel 3a", "Pixel 3a XL",
                "Pixel 4", "Pixel 4 XL", "Pixel 4a", "Pixel 4a 5G",
                "Pixel 5", "Pixel 5a 5G",
                "Pixel 6", "Pixel 6 Pro", "Pixel 6a",
                "Pixel 7", "Pixel 7 Pro", "Pixel 7a",
                "Pixel 8", "Pixel 8 Pro", "Pixel 8a",
                "Pixel 9", "Pixel 9 Pro", "Pixel 9 XL"
            ) +
            linea(
                "Alcatel",
                "1", "1B", "1C", "1S", "1SE", "1S 2020", "1T", "1T 10",
                "3", "3L", "3X", "5", "5V", "7", "7C",
                "Pop 2", "Pop 3", "Pop 4", "Pop 5", "Pop 6",
                "View", "View 2", "View 3", "Shine", "Go", "Ideal", "IdealX", "Pulse", "Axess"
            ) +
            linea(
                "Zonda",
                "Spark", "Nex", "Feel", "Shine", "Fly", "Speed", "Neo", "Max", "Pro", "Go", "Love"
            ) +
            linea(
                "BLU",
                "G50", "G60", "G70", "G80", "G90", "G90 Pro",
                "View 3", "View 4", "View 5", "View 6", "View 7",
                "Vivo 6", "Vivo XL", "Advance", "Neo", "Tank"
            ) +
            linea(
                "Multilaser",
                "F Max", "G Max", "F Pro", "E Max", "Air", "Music", "Vision", "G", "F", "C"
            ) +
            linea(
                "Lanix",
                "Alpha", "Delta", "Ilium", "Lynx", "Thor", "X"
            ) +
            linea(
                "Maxwest",
                "Astro", "Gravity", "Nitro", "Phantom", "Titan", "Vista", "Zumbo", "Orbit"
            ) +
            linea(
                "Asus",
                "Zenfone 5", "Zenfone 5Z", "Zenfone 6", "Zenfone 7", "Zenfone 8", "Zenfone 9",
                "Zenfone Max", "Zenfone Max Pro", "Zenfone Live", "Zenfone Lite"
            ) +
            linea(
                "Sony",
                "Xperia L1", "Xperia L3", "Xperia L4", "Xperia L5",
                "Xperia XA1", "Xperia XA2", "Xperia XA3", "Xperia XA5",
                "Xperia XZ", "Xperia XZ1", "Xperia XZ2", "Xperia XZ3",
                "Xperia 1", "Xperia 5", "Xperia 10", "Xperia 10 II", "Xperia 10 III", "Xperia 10 IV", "Xperia 10 V"
            ) +
            linea(
                "OnePlus",
                "Nord N10", "Nord N200", "Nord CE", "Nord CE Lite",
                "8", "8T", "9", "9R", "10 Pro", "11", "12"
            ) +
            linea(
                "TCL",
                "10", "10 Pro", "10 SE", "10 5G",
                "20", "20 Pro", "20 SE", "20 5G",
                "30", "30 SE", "30 5G", "30 Plus",
                "40", "40 SE", "40 5G", "40R", "50", "50 5G",
                "L5", "L7", "L9", "L11", "Plex", "Move"
            ) +
            linea(
                "Hisense",
                "E7", "E9", "H30", "H40", "Infinity", "King Kong", "H60", "A7", "A9"
            ) +
            linea(
                "Coolpad",
                "Cool", "Note", "Legacy", "Cool12", "Legacy 3", "N5", "N23"
            ) +
            linea(
                "Cubot",
                "Note", "King Kong", "Quest", "S", "Dinosaur", "Pocket", "X19", "X30"
            ) +
            linea(
                "Doogee",
                "N", "V", "S", "Y", "H", "Blade", "Mix", "X95"
            ) +
            linea(
                "Oukitel",
                "C", "K", "WP", "Y", "U", "Okta", "C50", "C55", "C56"
            ) +
            linea(
                "Ulefone",
                "Note", "Armor", "Power", "S", "A", "Paris", "Note 8", "Note 10", "Note 11", "Note 12", "Note 13"
            ) +
            linea(
                "Umidigi",
                "A", "B", "C", "S", "Power", "F1", "F2", "F3"
            ) +
            linea(
                "Meizu",
                "M", "Note", "U", "M5s", "M6s", "M8", "M9", "Note 8", "Note 9", "Note 10"
            ) +
            linea(
                "Microsoft",
                "Lumia 535", "Lumia 540", "Lumia 640", "Lumia 650", "Lumia 950", "Surface Duo"
            ) +
            linea(
                "BlackBerry",
                "KEY2", "KEYone", "DTEK50", "Motion", "Curve", "Bold"
            ) +
            linea(
                "Fairphone",
                "4", "5"
            ) +
            linea(
                "Nothing",
                "Phone (1)", "Phone (2)", "Phone (2a)"
            ) +
            linea(
                "Kodak",
                "Ektra", "Hero", "Orbit", "Slide"
            ) +
            linea(
                "Positivo",
                "Twist", "Unique", "Y+", "S45", "S50"
            ) +
            linea(
                "BQ",
                "Aquaris", "X", "X Pro", "M", "M8"
            ) +
            linea(
                "Crosscall",
                "Core", "Action", "Trek", "Element"
            ) +
            linea(
                "Gigaset",
                "GS", "GX", "GP", "MS"
            ) +
            linea(
                "iQOO",
                "Z", "Neo", "U", "V", "Z5", "Z7", "Z9", "Z9x", "Z9s"
            ) +
            linea(
                "Redmi",
                "A1", "A2", "A3", "9", "9A", "9C", "10", "12", "13", "14"
            )
        ).sorted()

    val POPULARES: List<String> = listOf(
        "Samsung A12",
        "Samsung A05",
        "Samsung A06",
        "Samsung A14",
        "Xiaomi Redmi 9",
        "Xiaomi Redmi 9A",
        "Xiaomi Redmi Note 12",
        "Xiaomi Redmi Note 13",
        "Motorola Moto G54",
        "Huawei Y9 2019",
        "Tecno Spark 10",
        "Infinix Hot 12",
        "Itel A60",
        "Nokia C12",
        "iPhone 11",
        "ZTE Blade A54"
    )

    fun buscar(texto: String): List<String> {
        val limpio = texto.trim()
        if (limpio.isEmpty()) return POPULARES

        val palabras = limpio.split(Regex("\\s+")).filter { it.isNotEmpty() }
        val coincide = TODAS.filter { entrada ->
            palabras.all { entrada.contains(it, ignoreCase = true) }
        }

        val prefijo = coincide.filter { it.startsWith(limpio, ignoreCase = true) }
        val resto = coincide.filterNot { it in prefijo }
        return (prefijo + resto).take(10)
    }

    fun marcaDe(entrada: String): String {
        val limpio = entrada.trim()
        return limpio.split(Regex("\\s+")).firstOrNull { it.isNotEmpty() }.orEmpty()
    }
}
