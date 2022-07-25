package jp.co.lib.library;

import java.util.Scanner;

public class MenuLibrary {
	//プロパティ
	//図書館
	SystemLibrary system; //図書館システム
	
	public MenuLibrary() {
		// TODO 自動生成されたコンストラクター・スタブ
		system = new SystemLibrary();
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
			Scanner scanCode = new Scanner(System.in);
			String tempCode = scanCode.next();
			int code = Integer.parseInt(tempCode);
			
			System.out.println("新しく登録する書籍の題名を入力してください");
			Scanner scanName = new Scanner(System.in);
			String name = scanName.next();
			
			System.out.println("新しく登録する書籍の作者名を入力してください");
			Scanner scanAuthor = new Scanner(System.in);
			String author = scanAuthor.next();
			
			System.out.println("新しく登録する書籍の出版社を入力してください");
			Scanner scanPublisher = new Scanner(System.in);
			String publisher = scanPublisher.next();
			
			System.out.println("新しく登録する書籍の出版年を入力してください");
			Scanner scanYear = new Scanner(System.in);
			String tempYear = scanYear.next();
			int year = Integer.parseInt(tempYear);
            
			this.system.create(code, name, author, publisher, year);
			
            break;
            
        //参照
        case 2:
        	
        	System.out.println("参照したい書籍のISBNコードを入力してください");
        	Scanner scanCode2 = new Scanner(System.in);
			String tempCode2 = scanCode2.next();
			int code2 = Integer.parseInt(tempCode2);
			
        	this.system.read(code2);
        	
            break;
        
        //更新
        case 3:
            this.system.update();
            break;
            
        //削除
        case 4:
        	System.out.println("削除したい書籍のISBNコードを入力してください");
        	Scanner scanCode3 = new Scanner(System.in);
			String tempCode3 = scanCode3.next();
			int code3 = Integer.parseInt(tempCode3);
			
        	this.system.delete(code3);
        	break;
        	
        //その他
        default:
            System.out.println("エラー: 0〜4の番号入力してください");
            break;
		}
	}
}