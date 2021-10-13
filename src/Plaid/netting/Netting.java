package Plaid.netting;


import java.util.*;

public class Netting {


    // A,B,1
    //B,C,2


    public static void main(String[] args) {
        Netting nettingEngine = new Netting();

      List<String> output1 =  nettingEngine.nettingGenerator(null);

      List<String> transactions1 = new ArrayList<>();
      List<String> output2 = nettingEngine.nettingGenerator(transactions1);

      transactions1.add("AB1");
      transactions1.add("BA2");
      transactions1.add("BC1");

      List<String> output3 = nettingEngine.nettingGenerator(transactions1);
        System.out.println(output1.size());
        System.out.println(output2.size());
        System.out.println(output3.size());

        for(String s : output3) {
            System.out.println(s);
        }



    }

    private static Character centralBank = 'A';
    public static boolean nettingGeneratorTransactionMore = false;

    public List<String> nettingGenerator(List<String> bankTransactions) {

        Map<Character,Integer> transactionMap = new HashMap<>();
        List<String> nettedTransactions = new ArrayList<>();


        List<String> superTransactions = new ArrayList<>();
        getNetTransactions(bankTransactions,superTransactions);

        if (bankTransactions != null && bankTransactions.size() !=0) {
            for(String singleTransaction : bankTransactions) {
                Character sendingBank = singleTransaction.charAt(0);
                Character receivingBank = singleTransaction.charAt(1);
                Integer amount = Integer.parseInt(singleTransaction.substring(2));

                int sendingBankAmount = transactionMap.getOrDefault(sendingBank,0);
                transactionMap.put(sendingBank,sendingBankAmount-amount);

                int receivingBankAmount = transactionMap.getOrDefault(receivingBank,0);
                transactionMap.put(receivingBank,receivingBankAmount+amount);
            }
        }

        if (transactionMap.size() != 0) {
            for (Map.Entry<Character,Integer> singleBankAmount : transactionMap.entrySet()) {
                if (singleBankAmount.getKey() != Netting.centralBank) {
                    StringBuilder tempTransactionBuilder = new StringBuilder();

                    if (singleBankAmount.getValue() < 0) {
                        tempTransactionBuilder.append(singleBankAmount.getKey());
                        tempTransactionBuilder.append(Netting.centralBank);
                        int amountToBeSent = singleBankAmount.getValue() * -1;
                        tempTransactionBuilder.append(amountToBeSent);
                        nettedTransactions.add(tempTransactionBuilder.toString());
                    } else {
                        tempTransactionBuilder.append(Netting.centralBank);
                        tempTransactionBuilder.append(singleBankAmount.getKey());
                        int amountToBeReceived = singleBankAmount.getValue();
                        tempTransactionBuilder.append(amountToBeReceived);
                        nettedTransactions.add(tempTransactionBuilder.toString());
                    }
                }
            }
        }


        if (nettedTransactions.size() > bankTransactions.size()) {
            System.out.println("You having more transactions than the initial transactions");
        }



        return nettedTransactions;
    }


    public void getNetTransactions(List<String> bankTransactions , List<String> netTransactions) {

//        Map<String,Integer> transactionMap = new HashMap<>();
//        for (String singleTransaction : netTransactions) {
//             int amount = transactionMap.getOrDefault(singleTransaction.substring(0,2),0);
//             transactionMap.put(singleTransaction.substring(0,2),amount+Integer.parseInt(singleTransaction.substring(2)));
//        }
//
//        for (Map.Entry<String,Integer> singleEntry : transactionMap.entrySet()) {
//            if (ma)
//        }
    }
}


