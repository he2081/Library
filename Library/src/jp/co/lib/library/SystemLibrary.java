package jp.co.lib.library;

import java.util.Scanner;

public class SystemLibrary {
	
	Bookdb library; //本棚
	
	public SystemLibrary() {
		// TODO 自動生成されたコンストラクター・スタブ
		library = new Bookdb();
	}
	
	//登録
	public void create(int isbnCode, String name, String author, String publisher, int year) {
		this.library.book = new BookInfo(isbnCode, name, author, publisher, year);  //本を作成
		this.library.bookList.add(this.library.book); //リストに追加
		System.out.println("書籍の登録が完了しました");
	}
	
	//参照
	public void read(int isbnCode) {
		
		boolean exist = true; //本の存在を確認するboolean型
		
		for(int i = 0; i < this.library.bookList.size(); i++) {
			if(this.library.bookList.get(i).getCode() == isbnCode) {
				System.out.println("-----------------------------------");
				System.out.println("ISBNコード: " + this.library.bookList.get(i).getCode());
				System.out.println("題名: " + this.library.bookList.get(i).getName());
				System.out.println("作者: " + this.library.bookList.get(i).getAuthor());
				System.out.println("出版社: " + this.library.bookList.get(i).getPublisher());
				System.out.println("出版年: " + this.library.bookList.get(i).getYear());
				System.out.println("状態: " + this.library.bookList.get(i).getStatus());
				System.out.println("-----------------------------------");
				exist = false;
			}
		}
		
		if(exist) {
			System.out.println("エラー: お探しの本は見つかりませんでした");
		}
	}
	
	//更新
	public void update() { 

//		Scannerの例
		
//		System.out.println("キーボードから入力してください");
//      Scanner scan = new Scanner(System.in);
//      String str = scan.next();
//      System.out.println("入力された文字は「" + str + "」です");
		
		System.out.println("情報を更新したい書籍のISBNコードを入力してください");
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
//		String型からint型に変換
//		例
//		String hoge = "1";
//		int num = Integer.parseInt(hoge);
//		System.out.println(num);
		
		int code = Integer.parseInt(str);
		
		boolean exist = true; //本の存在を確認するboolean型
		
		for(int i = 0; i < this.library.bookList.size(); i++) {
			if(this.library.bookList.get(i).getCode() == code) {
				
				exist = false;
				
				System.out.println("-----------------------------------");
				System.out.println("ISBNコード: " + this.library.bookList.get(i).getCode());
				System.out.println("題名: " + this.library.bookList.get(i).getName());
				System.out.println("作者: " + this.library.bookList.get(i).getAuthor());
				System.out.println("出版社: " + this.library.bookList.get(i).getPublisher());
				System.out.println("出版年: " + this.library.bookList.get(i).getYear());
				System.out.println("状態: " + this.library.bookList.get(i).getStatus());
				System.out.println("-----------------------------------");
				
				System.out.println("この書籍の情報を更新しますか？(yes/no)");
				
				Scanner scanAnswer = new Scanner(System.in);
				String answer = scanAnswer.next();
				
				if(answer.equals("yes")) {
					change(this.library.bookList.get(i));
					break;
				}else if(answer.equals("no")){
					break;
				}else {
					System.out.println("エラー: yes,またはnoで入力してください");
					break;
				}
			}
		}
		
		if(exist) {
			System.out.println("エラー: お探しの書籍は見つかりませんでした");
		}
	}
	
	//変更
	public void change(BookInfo book) {
		System.out.println("-----------------------------------");
		System.out.println("どの情報を変更しますか？");
		System.out.println("1: ISBNコード");
		System.out.println("2: 題名");
		System.out.println("3: 作者名");
		System.out.println("4: 出版社");
		System.out.println("5: 出版年");
		System.out.println("6: 貸出");
		System.out.println("-----------------------------------");
		
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
		int num = Integer.parseInt(str); //取得した値をint型に変換
		
		switch(num) {
		
		//ISBNコード
		case 1:
			
			System.out.println("新しいISBNコードを入力してください");
			Scanner scanCode = new Scanner(System.in);
			String tempCode = scanCode.next();
			int newCode = Integer.parseInt(tempCode);
			
//			//変更した本を新しく登録
//			create(newCode, book.getName(), book.getAuthor(), book.getPublisher(), book.getYear());
//			
//			//変更前の本を削除
//			delete(book.getCode());
			
			book.setCode(newCode); //更新
			
			System.out.println("ISBNコードの変更が完了しました");
			
			break;
			
		//題名
		case 2:
			
			System.out.println("新しい題名を入力してください");
			Scanner scanName = new Scanner(System.in);
			String newName = scanName.next();
			
			book.setName(newName); //更新
			
			System.out.println("題名の変更が完了しました");
			
			break;
			
		//作者
		case 3:
			
			System.out.println("新しい作者名を入力してください");
			Scanner scanAuthor = new Scanner(System.in);
			String newAuthor = scanAuthor.next();
			
			book.setAuthor(newAuthor); //更新
			
			System.out.println("作者名の変更が完了しました");
			
			break;
			
		//出版社
		case 4:

			System.out.println("新しい出版社を入力してください");
			Scanner scanPublisher = new Scanner(System.in);
			String newPublisher = scanPublisher.next();
			
			book.setPublisher(newPublisher); //更新
			
			System.out.println("出版社の変更が完了しました");
			
			break;
			
		//出版年
		case 5:

			System.out.println("新しい出版年を入力してください");
			Scanner scanYear = new Scanner(System.in);
			String tempYear = scanYear.next();
			int newYear = Integer.parseInt(tempYear);
			
			book.setYear(newYear); //更新
			
			System.out.println("出版年の変更が完了しました");
			
			break;
		
		//貸出
		case 6:
			
			if(book.getStatus2()) {
				System.out.println("現在この書籍は貸出可です。変更しますか？(yes/no)" );
				
				Scanner scanAnswer = new Scanner(System.in);
				String answer = scanAnswer.next();
				
				if(answer.equals("yes")) {
					book.setStatus(book.getStatus2());
					System.out.println("貸出中に変更しました" );
					break;
				}else if(answer.equals("no")){
					break;
				}else {
					System.out.println("エラー: yes,またはnoで入力してください");
					break;
				}
			}else {
				System.out.println("現在この書籍は貸出中です。変更しますか？(yes/no)" );
				
				Scanner scanAnswer2 = new Scanner(System.in);
				String answer2 = scanAnswer2.next();
				
				if(answer2.equals("yes")) {
					book.setStatus(book.getStatus2());
					System.out.println("貸出可に変更しました" );
					break;
				}else if(answer2.equals("no")){
					break;
				}else {
					System.out.println("エラー: yes,またはnoで入力してください");
					break;
				}
			}
			
			
		//その他
		default:
			System.out.println("エラー: 1〜6の番号で入力してください");
			break;
		}
		
	}
	
	//削除
	public void delete(int isbnCode) { 
		
		boolean exist = true; //本の存在を確認するboolean型
		
		for(int i = 0; i < this.library.bookList.size(); i++) {
			if(this.library.bookList.get(i).getCode() == isbnCode) {
				this.library.bookList.remove(this.library.bookList.get(i));
				System.out.println("書籍の削除が完了しました");
				exist = false;
				break; //処理を終えたので回避
			}
		}
		
		if(exist) {
			System.out.println("エラー: 入力されたコードの書籍は存在しません");
		}
	}

}