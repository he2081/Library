package jp.co.lib.library;

public class SystemLibrary {
    //プロパティ
    Bookdb library; //本棚
    
    //コンストラクター
    public SystemLibrary() {    
        library = new Bookdb();
    }
    
    //新しい書籍を登録
    public void createBook(int isbnCode, String name, String author, String publisher, int year) {
    	BookInfo newBook = new BookInfo(isbnCode, name, author, publisher, year);
        this.library.getBookList().add(newBook); //リストに追加
    }
    
    //貸出状況を変更
    public void changeStatus(BookInfo book) { 
        book.setStatus(book.getStatus());
    }
    
    //書籍を削除
    public void deleteBook(BookInfo book) { 
        library.getBookList().remove(book);
    }
}
