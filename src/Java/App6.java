package Java;

public class App6 {

    public static void main(String[] args) {
        byte[] arr = hexStringToByteArray("ad649636ed01cf845feda1350812c10f810e4f20334971d71ce8c0e399fe4368ffdb2e6a011e0d8045a1c96165e1c3366d0e1877de2b621e5cbd82ade02c082f1702e469be141727f519233ed27581b86d4c3509bcfff11ad82c131137625ef51b49920c2a6010ae087f5215cf659624eac16b16bf906a4a7aafeb715cdf810278d33e9db1cb7dce9c2fdeb3637d3d8a58bca04c0aff9beb6015cd89bbc50ded2625ea1bc6d7f581ef4828416db54268d13c67c65affa70a4e9742164f56c19aae85417f6b881ac29c028c112643e1dad0eb8905e6d455628192967bc6b7c27f178893064ecf29d4cfdfc01c42bdcd52300b45e495577e9f1486a591dd00ab3279a9cd79e055a065364264b115a22eb72ca6cb6409c1b6bbd5b28310ed66fd33c77e61853da9829dd2f68c083e6f03f9e3f66915adb971e511081f9dc07c021a13417a5e11aa2f5bd4df9b9699d7c0f0ab7144e36cfeeeb644c87318760db2d190163c77ebffa077db01138503addae5d838c02a9bf4a43a9cbd463548c338a0087f4a7b916c764467191dc2925d51b46c4330ca7e3a3a354abf1edc14f9ad42d8502e7bf8e775141733463faa10235bb140d46cc5bd65379f78d09b9b039cd8f3c4f620750556e06976e7a62da2ef23f95bfb2f156defff16ea91658cbe0e9f4f66d79d6df4ccacebfcefdd0879f9b5cc16fcfc875363fa0e2ff84d074e8b4c");
        System.out.println(arr.length);
    }

    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
