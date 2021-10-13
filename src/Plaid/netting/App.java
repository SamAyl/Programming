package Plaid.netting;

import java.util.*;

public class App {

    // Adds a bank with a list of accounts to the scheduler with the
// given interval (in seconds). Returns nothing.
    //add_bank(bank: string, accounts: Array<string>, interval: int) => void
// bofa : 3 acct : 2 sec
 //chase : 2 acct : 5sec

// Returns a mapping from banks to lists of accounts to update at
// the given timestamp.
    //get_accounts_to_update(timestamp: int) => Map<string, Array<string>>

//    Suppose we have two banks, "Chase" and "Wells Fargo". "Chase" has an update interval of 10 seconds, and "Wells Fargo" has an update interval of 20 seconds. "Chase" has accounts "username_1" and "username_2". "Wells Fargo" has account "username_3".
//
//    At T=0, all three accounts should be scheduled.
//    At T=5, no accounts should be scheduled.
//    At T=10, accounts "username_1" and "username_2" should be scheduled.
//    At T=20, all three accounts should be scheduled.


    public static void main(String[] args) {

        String[] chase = {"u1","u2","u3"};
        Integer chaseInterval = 2;

//               String[] WFargo = {"u2"};
//        Integer WFargoInterval = 20;

        try {
            add_bank("chase", chase, chaseInterval);
       //     add_bank("Wells Fargo", WFargo, WFargoInterval);
        }catch (Exception e) {
            System.out.println(e.toString());
        }

        Map<String,String[]> accountsUptdated = get_accounts_to_update(0);
//        print(accountsUptdated);
//
//        accountsUptdated = get_accounts_to_update(5);
//        print(accountsUptdated);
//
//        accountsUptdated = get_accounts_to_update(10);
//        print(accountsUptdated);
//        accountsUptdated = get_accounts_to_update(20);
//        print(accountsUptdated);
//
//        try {
//            add_bank("", null, 0);
//        }catch (Exception e) {
//            System.out.println("Exception must be received");
//        }
    }

    static Map<String,String[]> bankAccountInfo = new HashMap<String,String[]>();
     static Map<String,Long[]> bankRefreshIntervalInfo = new HashMap<String,Long[]>();


    public static void add_bank (String bankName, String[] arrOfAccountID, Integer interval) throws Exception {

        if (bankName == null || bankName.isEmpty()) {
            throw new Exception("Invalid Bank Name");
        }

        if (arrOfAccountID == null || arrOfAccountID.length == 0) {
            throw new Exception("Invalid Accounts");
        }

        if (interval<=0) {
            throw  new Exception("Refresh interval should be positive integer");
        }


        bankAccountInfo.put(bankName,arrOfAccountID);
        Long[] refreshIntervals = new Long[2];
        refreshIntervals[0] = (long)interval;
        refreshIntervals[1] = 0L;
        bankRefreshIntervalInfo.put(bankName,refreshIntervals);

        return;
    }


    public static Map<String, String[]> get_accounts_to_update(Integer timestamp) {

        Map<String,String[]> accountsUpdated = new HashMap<>();
        Long currentTimeStamp = (long)timestamp;
        for(Map.Entry<String,Long[]> bankEntry : bankRefreshIntervalInfo.entrySet()) {
            Long refreshInterval = bankEntry.getValue()[0];
            Long pastRefreshTime = bankEntry.getValue()[1];

            if (currentTimeStamp ==0 || currentTimeStamp - pastRefreshTime == refreshInterval) {
                refreshAllAccounts(bankAccountInfo.get(bankEntry.getKey()),refreshInterval);

                accountsUpdated.put(bankEntry.getKey(),bankAccountInfo.get(bankEntry.getKey()));
                bankEntry.getValue()[1] = currentTimeStamp;
            }
        }

        return accountsUpdated;
    }

    public static void refreshAllAccounts(String[] accountIds,Long refeshInterval){
        long perIntervalAccountsSize = (long)accountIds.length/refeshInterval;
        int strIdx = 0;
        int endIdx = (int)perIntervalAccountsSize;
       for(long str = 0 ; str <refeshInterval;str++) {
           System.out.println("Interval window number " + str);
          boolean reachedEndOfAllAccounts =  updateAccounts(accountIds,(int)strIdx, endIdx);
          if (!reachedEndOfAllAccounts) {
              strIdx = endIdx+1;
              endIdx = strIdx + (int) perIntervalAccountsSize;
          } else {
              break;
          }
       }
    }


    public static boolean updateAccounts(String[] accounts, int strIdx, int endIdx) {
        for(int i = strIdx; i<=endIdx;i++) {
            if (i<accounts.length) {
                System.out.println("updated"+accounts[i]);

            }else {
                return true;
            }
        }

        return false;
    }
    public static void print(Map<String,String[]> accts) {

        System.out.println("===============================");
        for (Map.Entry<String,String[]> entry : accts.entrySet()) {
            ;
            System.out.println(entry.getKey());
            for(String accoutns : entry.getValue()) {
                System.out.println(accoutns);
            }


        }

        System.out.println("========================");
    }


    public static void testApp() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        dq.add(2);

        Iterator<Integer> it = pq.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}
