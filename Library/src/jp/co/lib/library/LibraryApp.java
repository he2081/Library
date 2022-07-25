package jp.co.lib.library;

import java.util.*;

public class LibraryApp {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		
//		図書館のシステム
//		 - 本のCRUD　Create,Read、Update,Delete（登録、読み込み、編集、削除）
//		 - メニューがあること
//		 - 0 を選んだらシステムが終了すること
//
//		 本
//		 -　ISBN
//		 - 　題名
//		 -　作者
//		 -　出版社
//		 -　出版年
//		   詳細（）
		
		MenuLibrary myMenu = new MenuLibrary(); //メニュー画面に接続
		
		while(true) {
			myMenu.selectMain(); //選択画面を表示
			
			Scanner scan = new Scanner(System.in); //入力待ち
			String str = scan.next();
			
			int num = Integer.parseInt(str); //取得した値をint型に変換
			
			myMenu.operateMain(num); //取得した動作番号を関数に渡す
			
			while(true) {
				System.out.println("操作を続けますか？(yes/no)");
			
				Scanner scanAnswer = new Scanner(System.in);
				String answer = scanAnswer.next();
			
				if(answer.equals("yes")) {
					break;
				}else if(answer.equals("no")){
					System.out.println("システムを終了しました");
					System.exit(0);
				}else {
					System.out.println("エラー: yes、またはnoを入力してください");
					continue;
				}
			}	
		}
	}
}