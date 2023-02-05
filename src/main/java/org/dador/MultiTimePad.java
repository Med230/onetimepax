package org.dador;

/*bouajaj & ben ammar*
 *
 */
public class MultiTimePad {

    /**
     * Main function. Loads cryptogram and displays decryption
     *hgfhg
     * @param args No arguments are processed
     */
    public static void main(final String[] args) {
        String index = "000102030405060708090A0B0C0D0E0F101112131415161718191A1B1C1D1E";

        String msg0 = "ce38a99f9c89fc89e8c5c14190f7fe3f0de5c388e3670420c57db02e66ee51";
        String msg1 = "d43fb89f9092ebdbeecad10494bbf6220deed5dce36d0620c270b23223d351";
        String msg2 = "d370add2df8ce29ae3c5dc0f87bbfe715ee9d3daf27c546ddf6ba0356cf451";
        String msg3 = "d235ecd68cdcfa93e88bda0f8ce2bf2148fec3c7f928006f966ca12970ee51";
        String msg4 = "cd38a9d1df8fe694f8c7d14197febf3c48e9c488e3675464d938a7346ae940";
        String msg5 = "d370b8d79692e5dbf9c3d018c0e8f73e58e0d488f167186cd96ff3346af751";
        String msg6 = "ce38a5ccdf95fddbfddec70492bbeb394ce290dcff690020d976b67c6ae951";
        String[] messages = new String[]{msg0, msg1, msg2, msg3, msg4, msg5, msg6};
        int nbMsg = messages.length;
        byte[][] byteArrayMsg = new byte[nbMsg][];

        byte[] key;
        byte[] tmpByteMsg;
        int i;


        String displayIndex = HexConverters.toPrintableHexFromByteArray(HexConverters.toByteArrayFromHex(index));
        System.out.println("Original Cryptograms :");
        System.out.println(displayIndex);
        System.out.println("\n");

        // Transforme les messages sous un format "tableau d'octets" pour pouvoir les manipuler
        for (i = 0; i < nbMsg; i++) {
            tmpByteMsg = HexConverters.toByteArrayFromHex(messages[i]);
            byteArrayMsg[i] = tmpByteMsg;
            
      
            System.out.println(HexConverters.toPrintableHexFromByteArray(byteArrayMsg[i]));
        }
        
        tmpByteMsg = HexConverters.toByteArrayFromHex(messages[0]);

        System.out.println();

        key = new byte[msg1.length() / 2];
        // Fill in the key ...
        key[0] = (byte) 0x9a;
		key[1] = (byte) 0x50;
		key[2] = (byte) 0xcc;
		key[3] = (byte) 0xbf;
		key[4] = (byte) 0xff;
		key[5] = (byte) 0xfc;
		key[6] = (byte) 0x8e;
		key[7] = (byte) 0xfb;
		key[8] = (byte) 0x8d;
		key[9] = (byte) 0xab;
		key[10] = (byte) 0xb5;
		key[11] = (byte) 0x61;
		key[12] = (byte) 0xe0;
		key[13] = (byte) 0x9b;
		key[14] = (byte) 0x9f;
		key[15] = (byte) 0x51;
		key[16] = (byte) 0x2d;
		key[17] = (byte) 0x8c;
		key[18] = (byte) 0xb0;
		key[19] = (byte) 0xa8;
		key[20] = (byte) 0x97;
		key[21] = (byte) 0x08;
		key[22] = (byte) 0x74;
		key[23] = (byte) 0x00;
		key[24] = (byte) 0xb6;
		key[25] = (byte) 0x18;
		key[26] = (byte) 0xd3;
		key[27] = (byte) 0x5c;
		key[28] = (byte) 0x3;
		key[29] = (byte) 0x9a;
		key[30] = (byte) 0x7f;
        
        
       
     
        System.out.println("Key :");
        System.out.println(displayIndex);
        System.out.println(HexConverters.toPrintableHexFromByteArray(key));

        // Affichage des messages décodés
        System.out.println();
        System.out.println("xor messages :");
        i = 0;
        while (i < nbMsg) {
            //System.out.println(HexConverters.toPrintableString(tmpByteMsg));
            System.out.println(HexConverters.toPrintableHexFromByteArray(HexConverters.xorArray(tmpByteMsg, byteArrayMsg[i])));
            i++;
        }
     // Affichage des messages décodés
        System.out.println();
        System.out.println("Decoded messages :");
        i = 0;
        while (i < nbMsg) {
            tmpByteMsg = HexConverters.xorArray(tmpByteMsg, byteArrayMsg[i]);
            System.out.println(HexConverters.toPrintableString(tmpByteMsg));
            i++;
        }
    }
}
