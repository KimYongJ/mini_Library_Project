# mini_Library_Project
미니 도서관 프로젝트
[ 코드작성 내용 간단 설명 ]
1)	전체적인 기능들을 설계하고 패키지를 뷰, util, 서비스, 모델, exception, dao, 
	컨트롤로 나눈다. 
2) 
	[메인클래스] 책이름으로 책검색 searchBooks() -> 
	[컨트롤러클래스] 책이름을 입력받고 ->
	[ 서비스클래스] 에서 책의 데이터를 전달받을 ArrayList를 만든다 ->
	[ AllDAO클래스 ] 에서 특정이름의 데이터를 추출해 반환해준다.
3) 
	[메인클래스]-> 메인에서 책 id와 유저id로 책빌리기 borrowUseID함수를 실행
	[컨트롤클래스]-> 유저와 책 ID 를 입력 받아 서비스 클래스로 데이터를 전달한다.
	[서비스클래스]-> 책 ID로 부터 수량과 책 id가 맞는지 확인한다(flagReturn함수) 
		bookID가 있다면 userID와 bookID로 rental_info테이블에 데이터를 입력한다.(borrowBooks함수)
		그리고 changeFlag함수를 실행해 book테이블의 수량을 하나 뺀다.(changeFlag함수)


[ 주의 ]
1) SQL 관련 자르파일 설정을 따로 해야한다.
2) SQL과 연결되어 있기 때문에 SQL 테이블을 생성해야 한다.( SQL ID와 비번은 scott , tiger )
USE `scott` ;
// person 테이블
CREATE TABLE IF NOT EXISTS `scott`.`person` (
  `id_number` INT NOT NULL AUTO_INCREMENT,
  `phone_num` VARCHAR(20) NULL,
  `user_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_number`))
// book 테이블
CREATE TABLE IF NOT EXISTS `scott`.`book` (
  `book_number` INT NOT NULL AUTO_INCREMENT,
  `genre` VARCHAR(10) NULL,
  `publication` VARCHAR(40) NULL,
  `borrow_flag` INT NULL,
  `book_name` VARCHAR(50) NULL,
  PRIMARY KEY (`book_number`))
// rental_info 테이블
CREATE TABLE IF NOT EXISTS `scott`.`rental_info` (
  `rental_info_id` INT NOT NULL AUTO_INCREMENT,
  `borrow_day` VARCHAR(40) NULL,
  `return_day` VARCHAR(40) NULL,
  `id_number` INT NOT NULL,
  `book_number` INT NOT NULL,
  PRIMARY KEY (`rental_info_id`),
  INDEX `fk_rental_info_person_idx` (`id_number` ASC) VISIBLE,
  INDEX `fk_rental_info_Book1_idx` (`book_number` ASC) VISIBLE,
  CONSTRAINT `fk_rental_info_person`
    FOREIGN KEY (`id_number`)
    REFERENCES `mydb`.`person` (`id_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_rental_info_Book1`
    FOREIGN KEY (`book_number`)
    REFERENCES `mydb`.`book` (`book_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
// 데이터 삽입 코드
insert into person(phone_num,user_name) values("010-0000-0000","가나다");
insert into person(phone_num,user_name) values("010-1111-1111","라마바");
insert into person(phone_num,user_name) values("010-2222-2222","사아자");
insert into book(genre,publication,borrow_flag,book_name) values("소설","2022-06-16","0","가나다책");
insert into book(genre,publication,borrow_flag,book_name) values("시","2022-06-16","0","라마바책");
insert into book(genre,publication,borrow_flag,book_name) values("희곡","2022-06-16","0","사아자책");



