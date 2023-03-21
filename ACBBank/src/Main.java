import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // set up list data
        List<Account> accountList = new ArrayList<Account>();
        accountList.add(new Account(1234567891L,"Nguyễn Đưc Sáng",500.0));
        accountList.add(new Account(1234567892L,"Tạ Quang Sang",600.0));
        accountList.add(new Account(1234567893L,"Nguyễn Đức Trí"));
        int checkRound01 = 1;
        while (checkRound01 != 2){
            System.out.println("--------------------------------");
            System.out.println("Nhập yêu cầu:");
            System.out.println(" 1. Đăng nhập.\n" +
                    " 2. Thoát.");
            System.out.println("--------------------------------");
            checkRound01 = scanner.nextInt();
            switch (checkRound01) {
                case 1:
                    Account accountMain = getAccount(scanner, accountList);
                    int checkRound02 = 1;
                    while (checkRound02 != 5){
                        // set up UI
                        System.out.println("--------------------------------");
                        System.out.println("Nhập yêu cầu:");
                        System.out.println(" 1. Vấn tin số dư.\n" +
                                " 2. Nạp tiền vào tài khoản.\n" +
                                " 3. Rút tiền.\n" +
                                " 4. Chuyển tiền.\n" +
                                " 5. Đăng xuất.");
                        System.out.println("--------------------------------");
                        checkRound02 = scanner.nextInt();
                        double money;
                        switch (checkRound02){
                            case 1:
                                System.out.println(accountMain);
                                System.out.println("    ------------------------");
                                checkRound02 = checkRequestContinuation(scanner, checkRound02);
                                break;
                            case 2:
                                System.out.println("Nhập số tiền cần nạp: ");
                                money = scanner.nextDouble();
                                System.out.println(accountMain.depositMoney(money));
                                System.out.println("    ------------------------");
                                checkRound02 = checkRequestContinuation(scanner, checkRound02);
                                break;
                            case 3:
                                System.out.println("Nhập số tiền muốn rút: ");
                                money = scanner.nextDouble();
                                System.out.println(accountMain.withdrawMoney(money));
                                System.out.println("    ------------------------");
                                checkRound02 = checkRequestContinuation(scanner, checkRound02);
                                break;
                            case 4:
                                System.out.println("Nhập tài khoản muốn chuyển tiền vào: ");
                                Long accountIdReceived = scanner.nextLong();
                                Account accountReceived = getAccount(accountList, accountIdReceived);
                                if (accountReceived == null){
                                    System.out.println("Tài khoản chuyển tiền vào không tồn tại");
                                    System.out.println("    ------------------------");
                                    checkRound02 = checkRequestContinuation(scanner, checkRound02);
                                    break;
                                }
                                System.out.println("Nhập số tiền muốn chuyển: ");
                                money = scanner.nextLong();
                                System.out.println(accountMain.tranferMoney(money, accountReceived));
                                System.out.println("    ------------------------");
                                checkRound02 = checkRequestContinuation(scanner, checkRound02);
                                break;
                            case 5:
                                accountMain = new Account();
                                for (int i = 0; i < 50; ++i) System.out.println();
                                break;
                            default:
                                System.out.println("Vui lòng nhập đúng yêu cầu!!!");
                                System.out.println("    ------------------------");
                                System.out.println("Tiếp tục thực hiện giao dịch (y/n)?");
                                checkRound02 = checkRequestContinuation(scanner, checkRound02);
                        }
                    }
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Vui lòng nhập đúng yêu cầu!!!");
            }
        }

    }

    public static Account getAccount(List<Account> accountList,Long accountId){
        Account accountMain;
        for (Account account : accountList){
            if (Objects.equals(account.getAccountId(), accountId)) {
                accountMain = account;
                return accountMain;
            }
        }
        return null;
    }

    public static int checkRequestContinuation(Scanner sc, int checkRound02){
        char check = 't';
        while (check != 'n' && check != 'y'){
            System.out.println("Tiếp tục thực hiện giao dịch (y/n)?");
            check = sc.next().charAt(0);
            if (check == 'n') {
                checkRound02 = 5;
                for (int i = 0; i < 50; ++i) System.out.println();
            }
        }
        return checkRound02;
    }

    public static Account getAccount(Scanner scanner, List<Account> accountList){
        long accountIdMain;
        boolean checkNullAccount = true;
        Account accountMain = new Account();
        while (checkNullAccount){
            System.out.println("Nhập số tài khoản:");
            accountIdMain = scanner.nextLong();
            accountMain = getAccount(accountList,accountIdMain);
            if (accountMain == null) {
                System.out.println("Tài khoản không tồn tại!!!");
            }
            else {
                checkNullAccount = false;
            }
        }
        return accountMain;
    }

}