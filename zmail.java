import java.util.*;
class Storage{
    String id;
    String password;
    ArrayList<String> inbox;
    ArrayList<String> sent_mails;
    ArrayList<String> trash;
    Storage(String i, String pw){
        id=i;
        password=pw;
        inbox=new ArrayList<String>();
        sent_mails=new ArrayList<String>();
        trash=new ArrayList<String>();
    }
}
public class zmail{

    public static boolean check_userid(ArrayList<Storage> s, String un){
        if(s.size()==0){
            return true;
        }
        else{
            for(Storage t: s){
                if(t.id.equals(un)){
                    return false;
                }
            }
            return true;
        }
    }

    public static boolean check_credentials(ArrayList<Storage> s, String un, String pw){
        for(Storage t: s){
            if(t.id.equals(un) && t.password.equals(pw)){
                return true;
            }
        }
        return false;
    }

    public static void sent_mails(ArrayList<Storage> s, String rm, String sm, String t, String t1){
        for(Storage t2: s){
            if(t2.id.equals(rm)){
                t2.inbox.add(t);
            }
            if(t2.id.equals(sm)){
                t2.sent_mails.add(t1);
            }
        }
        System.out.println("\n....Mail Successfully Send....\n");
    }

    public static void display_inbox(ArrayList<Storage> s, String um){
        for(Storage t1: s){
            if(t1.id.equals(um)){
                if(t1.inbox.size()==0){
                    System.out.println("\n...Inbox is empty...\n");
                    break;
                }
                else{
                    System.out.println("\n....Inbox....\n");
                    for(String m: t1.inbox){
                        System.out.println(m);
                    }
                    break;
                }
            }
        }
    }

    public static void display_sent_mails(ArrayList<Storage> s, String um){
        for(Storage t1: s){
            if(t1.id.equals(um)){
                if(t1.sent_mails.size()==0){
                    System.out.println("\n...Sent mails is empty...\n");
                    break;
                }
                else{
                    System.out.println("\n....Sent Mails....\n");
                    for(String m: t1.sent_mails){
                        System.out.println(m);
                    }
                    break;
                }
            }
        }
    }

    public static void display_trash(ArrayList<Storage> s, String um){
        for(Storage t1: s){
            if(t1.id.equals(um)){
                if(t1.trash.size()==0){
                    System.out.println("\n...Trash mails is empty...\n");
                    break;
                }
                else{
                    System.out.println("\n....Trash Mails....\n");
                    for(String m: t1.trash){
                        System.out.println(m);
                    }
                    break;
                }
            }
        }
    }

    public static void delete_inbox_mails(ArrayList<Storage> s, String um){
        Scanner sc1 = new Scanner(System.in);
        boolean r=false;
        String dm;
        for(Storage t1: s){
            if(t1.id.equals(um)){
                if(t1.inbox.size()==0){
                    System.out.println("\n....Inbox is empty....\n");
                    break;
                }
                else{
                    System.out.println("\nEnter the Delete mail from inbox: ");
                    dm=sc1.nextLine();
                    for(String m: t1.inbox){
                        if(m.contains(dm)){
                            t1.trash.add(m);
                            t1.inbox.remove(m);
                            r=true;
                            break;
                        }
                    }
                    if(r){
                        System.out.println("\n....Inbox Mail deleted successfully....\n");
                    }
                    else{
                        System.out.println("\n....Maild Id not found....\n");
                    }
                    break;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("\n...............Welcome to Zmail...............\n");

        int n1;
        String usr_id, password;
        boolean rpt=true;
        ArrayList<Storage> s=new ArrayList<Storage>();

        while(rpt){
            System.out.println("\n1. New account\r\n" + //
            "2. Login\r\n" + //
            "3. Exit\n");
            System.out.print("Enter the number: ");
            n1=sc.nextInt();
            sc.nextLine();
            if(n1==1){
                System.out.print("Enter the User Id: ");
                usr_id=sc.nextLine();
                if(s.isEmpty() || check_userid(s,usr_id)){
                    System.out.print("Enter the Password: ");
                    password=sc.nextLine();
                    Storage sg=new Storage(usr_id, password);
                    s.add(sg);
                    System.out.println("\n!....Account Successfully created....!\n");
                }
                else{
                    System.out.println("\n!....User Id already exists....!\n");
                }
            }

            else if(n1==2){
                System.out.println("Enter the Login Credentials: ");
                System.out.print("Enter the User Id: ");
                String un=sc.nextLine();
                System.out.print("Enter the Password: ");
                String pw=sc.nextLine();
                if(s.isEmpty()){
                    System.out.print("\n....You don't have account kindly create the account....\n");
                }
                else if(check_credentials(s,un,pw)){
                    System.out.print(un + "....Successfully Logged In....\n");
                    while(true){
                        System.out.println("\n1. Compose\r\n" + //
                        "2. Inbox\r\n" + //
                        "3. Sent Mails\n" +
                        "4. Delete Inbox Mails\n" +
                        "5. Trash\r\n" + 
                        "6. Logout\r\n");
                        System.out.print("Enter the Number: ");
                        int n2=sc.nextInt();
                        sc.nextLine();
                        if(n2==1){
                            ArrayList<String> mail_ids=new ArrayList<String>();
                            String sub;
                            String msg;
                            System.out.print("How many mails will be sent...? Enter in number: ");
                            int n3=sc.nextInt();
                            sc.nextLine();
                            for(int i=0;i<n3;i++){
                                System.out.print("Enter the "+(i+1)+" mail id: ");
                                String sending_maid_id=sc.nextLine();
                                if(!check_userid(s, sending_maid_id)){
                                    mail_ids.add(sending_maid_id);
                                }
                                else{
                                    System.out.println("...Enter the correct mail id...");
                                }
                            }
                            if(mail_ids.size()!=0){
                                System.out.print("Enter the Subject: ");
                                sub=sc.nextLine();
                                System.out.print("Enter the Msg: ");
                                msg=sc.nextLine();
                                System.out.println("\n1. Send\r\n" +
                                "2. Cancel\r\n");
                                System.out.print("Enter the Number: ");
                                int n4=sc.nextInt();
                                sc.nextLine();
                                if(n4==1){
                                    for(String rm:mail_ids){
                                        String t="From: "+un+" Sub: "+sub+" msg: "+msg;
                                        String t1="To: "+rm+" Sub: "+sub+" msg: "+msg;
                                        sent_mails(s,rm,un,t,t1);
                                    }
                                }
                                else{
                                    System.out.println("\n....Mail not Send....\n");
                                }
                            }
                            else{
                                System.out.println("\n....Mail Id not entered....\n");
                            }

                        }
                        else if(n2==2){
                            display_inbox(s, un);
                        }
                        else if(n2==3){
                            display_sent_mails(s, un);
                        }
                        else if(n2==4){
                            delete_inbox_mails(s, un);
                        }
                        else if(n2==5){
                            display_trash(s, un);
                        }
                        else if(n2==6){
                            System.out.println("\n....Logout Successfully....\n");
                            break;
                        }
                    }
                }
                else{
                    System.out.print("\n....Check the User Id and Password....!\n");
                }   
            }

            else if(n1==3){
                rpt=false;
            }
        }

    }
}