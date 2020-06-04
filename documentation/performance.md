Viikolla 4. algoritmien toimintaa tutkittiin alustavasti tällä koodilla

        System.out.println("Suorituskyvyn testausta: ");
        System.out.println("Ensin Huffman-algoritmi:");
        String test = "suorituskyvyn testaus";
        System.out.println("Käytetty testilause " + test);
        HuffmanAlgo huff = new HuffmanAlgo();
        LempelZivWelchAlgo lempel = new LempelZivWelchAlgo();

        long start = System.currentTimeMillis();
        String encoded = huff.encodeString(test);
        System.out.println("Enkoodattuna test näyttää tältä: " + encoded);
        long encodingDone = System.currentTimeMillis();
        String decoded = huff.decodeString(encoded);
        System.out.println("dekoodattu: " + decoded);
        long decodingDone = System.currentTimeMillis();

        long enc = encodingDone - start;
        System.out.println("Enkoodauksessa meni aikaa: " + enc + " millisekuntia");
        int size = huff.huffmanTree.size();

        System.out.println("Huffmantreen koko " + size + " ja test-stringin koko " + test.length());
        long dec = decodingDone - encodingDone;
        System.out.println("Huffmanin dekoodauksessa meni aikaa: " + dec + " millisekuntia");
        System.out.println("Alkuperäinen testi: " + test + " ja enkoodauksen jälkeen palautettu: " + decoded);
        System.out.println("");
        System.out.println("Sitten LZW:n testaus samalla stringillä");
        long lempelStart = System.currentTimeMillis();
        List<Integer> lempelEncoding = lempel.encodeString(test);
        long lempelEncoded = System.currentTimeMillis();
        String lempelDecoded = lempel.decodeString();
        long lempelEnd = System.currentTimeMillis();

        long lempelEnc = lempelEncoded - lempelStart;
        long lempelFinished = lempelEnd - lempelEncoded;
        System.out.println("LZW enkoodauksessa meni aikaa " + lempelEnc + " millisekuntia");
        System.out.println("Koodattuna näyttää tältä: "+ lempelEncoding);
        System.out.println("LZW dekoodauksessa meni aikaa " + lempelFinished + " millisekuntia");
        System.out.println("LZW:ssä String on alunperin " + test.length() + " pituinen ja koodattuna se on " + lempelEncoding.size() + " pituinen");
