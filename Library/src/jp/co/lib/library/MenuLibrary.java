package jp.co.lib.library;

import java.util.Scanner;

public class MenuLibrary {
	//プロパティ
	//図書館
	SystemLibrary system; //図書館システム
	Scanner scan = new Scanner(System.in);
	
	//コンストラクター
	public MenuLibrary() {
		system = new SystemLibrary();
	}
	
	//スキャナー(戻り値：整数型)
	public int inputInteger() {
		String tempAnswer = scan.next();
		int answer = Integer.parseInt(tempAnswer); //取得した値を整数型に変換
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
			System.out.println("エラー: お探しの本は見つかりませんでした");
		}
	}
	
	//選択画面
	public void selectMain() {
		System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		System.out.println("図書館管理システム");
        System.out.println("操作番号をしてください");
        System.out.println("0: exit(終了)");
        System.out.println("1: create(登録)");
        System.out.println("2: read(参照)");
        System.out.println("3: update(更新)");
        System.out.println("4: delete(削除)");
        System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
	}
	
	//動作メソッド
	public void operateMain(int num) {
		switch(num) {
		
		//終了
		case 0:
			System.out.println("システムを終了しました");
			System.exit(0);
			
		//登録
		case 1:
			
			System.out.println("新しく登録する書籍のISBNコードを入力してください");
			int case1Code = inputInteger();
			
			System.out.println("新しく登録する書籍の題名を入力してください");
			String name = inputString();
			
			System.out.println("新しく登録する書籍の作者名を入力してください");
			String author = inputString();
			
			System.out.println("新しく登録する書籍の出版社を入力してください");
			String publisher = inputString();
			
			System.out.println("新しく登録する書籍の出版年を入力してください");
			int year = inputInteger();
            
			system.create(case1Code, name, author, publisher, year);
			System.out.println("書籍の登録が完了しました");
			
            break;
            
        //参照
        case 2:
        	
        	System.out.println("参照したい書籍のISBNコードを入力してください");
			int case2Code = inputInteger();
			
			//system.library.passBookInfo():入力されたコードの書籍を本棚から探してくる
			BookInfo case2Book = system.library.passBookInfo(case2Code);
			displayInfo(case2Book);
        	
            break;
        
        //貸出状況の変更
        case 3:
        	
        	System.out.println("貸出状況を変更したい書籍のISBNコードを入力してください");
        	int case3Code = inputInteger();
        	
        	BookInfo case3Book = system.library.passBookInfo(case3Code);
        	displayInfo(case3Book);
        	
        	if(case3Book != null) {
        		while(true) {
        			System.out.println("書籍の状態を変更しますか？(yes/no)" );
        			String case3Answer = inputString();
        			
        			if(case3Answer.equals("yes")) {
        				system.changeStatus(case3Book);
        				System.out.println("変更が完了しました");
        				break;
        			}else if(case3Answer.equals("no")){
        				break;
        			}else {
        				System.out.println("エラー: yes,またはnoで入力してください");
        				continue;
        			}
        		}
        	}
        	
            break;
            
        //削除
        case 4:
        	System.out.println("削除したい書籍のISBNコードを入力してください");
        	int case4Code = inputInteger();
        	
        	BookInfo case4Book = system.library.passBookInfo(case4Code);
        	displayInfo(case4Book);
        	
        	if(case4Book != null) {
        		while(true) {
        			System.out.println("この書籍を削除しますか？(yes/no)" );
        			String case4Answer = inputString();
        			
        			if(case4Answer.equals("yes")) {
        				system.deleteBook(case4Book);
        				System.out.println("書籍の削除が完了しました");
        				break;
        			}else if(case4Answer.equals("no")){
        				break;
        			}else {
        				System.out.println("エラー: yes,またはnoで入力してください");
        				continue;
        			}
        		}
        	}
			
        	break;
        	
        //その他
        default:
            System.out.println("エラー: 0〜4の番号入力してください");
            break;
		}
	}
}