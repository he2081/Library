package jp.co.lib.library;

import java.util.Scanner;

public class MenuLibrary {
    //プロパティ
    SystemLibrary system; //図書館システム
    Scanner scan = new Scanner(System.in); //スキャナー
    
    //コンストラクター
    public MenuLibrary() {
        system = new SystemLibrary();
    }
    
    //スキャナー(戻り値：整数型)
    public int inputInteger() {
    	
    	int answer = 0;
    	try {
    		String tempAnswer = scan.next();
    		answer = Integer.parseInt(tempAnswer); //取得した値を整数型に変換
    		
    	}catch (NumberFormatException e){
    	    System.out.println("エラー: 入力された値は数値に変換できません。数値で入力してください。");
    	    System.out.print("＞");
    	    answer = inputInteger();    	    
    	}
    	
    	return answer;
    }
    
    //スキャナー(戻り値：整数型)
    public String inputString() {
        String answer = scan.next();
        return answer;
    }
    
    //書籍情報を表示
    public void displayInfo(BookInfo book) {    
        if(book != null) {
            System.out.println("-----------------------------------");
            System.out.println("ISBNコード: " + book.getCode());
            System.out.println("題名: " + book.getName());
            System.out.println("作者: " + book.getAuthor());
            System.out.println("出版社: " + book.getPublisher());
            System.out.println("出版年: " + book.getYear());
            System.out.println("状態: " + book.getStatusString());
            System.out.println("-----------------------------------");
        }else {
            System.out.println("エラー: 検索された書籍は見つかりませんでした。");
        }
    }
    
    //選択画面
    public void selectMain() {
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
        System.out.println("図書館管理システム");
        System.out.println("操作番号を入力してください");
        System.out.println("0: exit(終了)");
        System.out.println("1: register(登録)");
        System.out.println("2: search(検索)");
        System.out.println("3: change(貸出状況の変更)");
        System.out.println("4: delete(削除)");
        System.out.println("5: show(書籍の一覧)");
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
    }
    
    //動作メソッド
    public void operateMain(int num) {
        switch(num) {
        //終了
        case 0:
            System.out.println("システムを終了しました。");
            System.exit(0);
        //登録
        case 1:
        	System.out.println("新しく登録する書籍のISBNコードを入力してください。");
        	System.out.print("＞");
        	int case1Code = inputInteger();
        		
        	//同じISBNコードの書籍がないかどうかチェックする
        	//本棚クラスにアクセスして書籍の情報を取得
        	BookInfo checkBook = system.library.passBookInfo(case1Code);
            
        	if(checkBook != null) {
        		System.out.println("エラー: 入力されたISBNコードの書籍が既に登録済みです。");
        		break;
        	}
            
            System.out.println("新しく登録する書籍の題名を入力してください。");
            System.out.print("＞");
            String name = inputString();
            System.out.println("新しく登録する書籍の作者名を入力してください。");
            System.out.print("＞");
            String author = inputString();
            System.out.println("新しく登録する書籍の出版社を入力してください。");
            System.out.print("＞");
            String publisher = inputString();
            System.out.println("新しく登録する書籍の出版年を入力してください。");
            System.out.print("＞");
            int year = inputInteger();
            
            System.out.println("-----------------------------------");
            System.out.println("ISBNコード: " + case1Code);
            System.out.println("題名: " + name);
            System.out.println("作者: " + author);
            System.out.println("出版社: " + publisher);
            System.out.println("出版年: " + year);
            System.out.println("状態: □ 貸出可");
            System.out.println("-----------------------------------");
            
            
            
            while(true) {
        		System.out.println("この情報で登録しますか？(yes/no)");
        		System.out.print("＞");
        		String case1Answer = inputString();
        		
        		if(case1Answer.equals("yes")) {
        			system.createBook(case1Code, name, author, publisher, year);
        			System.out.println("書籍の登録が完了しました。");
        			break;
        		}else if(case1Answer.equals("no")){
        			break;
        		}else {
        			System.out.println("エラー: yes,またはnoで入力してください。");
        			continue;
        		}
        	}
        	break;
        //参照
        case 2:
            System.out.println("検索したい書籍のISBNコードを入力してください。");
            System.out.print("＞");
            int case2Code = inputInteger();
            //system.library.passBookInfo():入力されたコードの書籍を本棚から探してくる
            BookInfo case2Book = system.library.passBookInfo(case2Code);
            displayInfo(case2Book);
            break;
        //貸出状況の変更
        case 3:
            System.out.println("貸出状況を変更したい書籍のISBNコードを入力してください。");
            System.out.print("＞");
            int case3Code = inputInteger();
            BookInfo case3Book = system.library.passBookInfo(case3Code);
            displayInfo(case3Book);
            if(case3Book != null) {
                while(true) {
                    System.out.println("書籍の状態を変更しますか？(yes/no)" );
                    System.out.print("＞");
                    String case3Answer = inputString();
                    if(case3Answer.equals("yes")) {
                        system.changeStatus(case3Book);
                        System.out.println("変更が完了しました。");
                        break;
                    }else if(case3Answer.equals("no")){
                        break;
                    }else {
                        System.out.println("エラー: yes,またはnoで入力してください。");
                        continue;
                    }
                }
            }
            break;
        //削除
        case 4:
            System.out.println("削除したい書籍のISBNコードを入力してください。");
            System.out.print("＞");
            int case4Code = inputInteger();
            BookInfo case4Book = system.library.passBookInfo(case4Code);
            displayInfo(case4Book);
            if(case4Book != null) {
                while(true) {
                    System.out.println("この書籍を削除しますか？(yes/no)" );
                    System.out.print("＞");
                    String case4Answer = inputString();
                    if(case4Answer.equals("yes")) {
                        system.deleteBook(case4Book);
                        System.out.println("書籍の削除が完了しました。");
                        break;
                    }else if(case4Answer.equals("no")){
                        break;
                    }else {
                        System.out.println("エラー: yes,またはnoで入力してください。");
                        continue;
                    }
                }
            }
            break;
        //書籍の一覧表示    
        case 5:
        	while(true) {
        		System.out.println("システムに登録されている書籍を一覧表示しますか？(yes/no)");
        		System.out.print("＞");
        	
        		String case5Answer = inputString();
        		if(case5Answer.equals("yes")) {
        			system.library.showLibrary();
        			break;
        		}else if(case5Answer.equals("no")){
        			break;
        		}else {
        			System.out.println("エラー: yes,またはnoで入力してください。");
        			continue;
        		}
        	}
        	break;
        	
        //その他
        default:
            System.out.println("エラー: 0～5の番号入力してください。");
            break;
        }
    }
}
