//      図書館管理システム
//       - 本のCRUD　Create,Read、Update,Delete（登録、読み込み、編集、削除）
//       - メニューがあること
//       - 0 を選んだらシステムが終了すること
//
//       本
//       -　ISBN
//       - 　題名
//       -　作者
//       -　出版社
//       -　出版年
//         詳細（）

package jp.co.lib.library;

public class LibraryApp {
    public static void main(String[] args) {
        MenuLibrary myMenu = new MenuLibrary(); //メニュー画面に接続
        while(true) {
            myMenu.selectMain(); //選択画面を表示
            System.out.print("＞");
            myMenu.operateMain(myMenu.inputInteger()); //取得した動作番号を関数に渡す
            while(true) {
                System.out.println("操作を続けますか？(yes/no)");
                System.out.print("＞");
                String answer = myMenu.inputString();
                if(answer.equals("yes")) {
                    break;
                }else if(answer.equals("no")){
                    System.out.println("システムを終了しました。");
                    System.exit(0);
                }else {
                    System.out.println("エラー: yes、またはnoを入力してください。");
                    continue;
                }
            }   
        }
    }
}