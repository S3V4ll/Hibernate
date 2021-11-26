package entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.*;

@Entity
@Table(name="Author")
public class Author {
	
	@Id                        
	@Column(name="Author_id")
	private int Author_id;
	
	@Column(name="Author_book_name ")
	private String Author_book_name ;
	
	@Column(name="Author_total_publications")
	private int Author_total_publications;
	
	@Column(name="Autor_website")
	private String Autor_website;
	
	@Column(name="Author_is_new")
	private int Author_is_new;
	
	
	public Author() {

	}


	public Author(String author_book_name, int author_total_publications, String autor_website, int author_is_new) {
		
		this.Author_book_name = author_book_name;
		this.Author_total_publications = author_total_publications;
		this.Autor_website = autor_website;
		this.Author_is_new = author_is_new;
	}


	public int getAuthor_id() {
		return Author_id;
	}


	public void setAuthor_id(int author_id) {
		Author_id = author_id;
	}


	public String getAuthor_book_name() {
		return Author_book_name;
	}


	public void setAuthor_book_name(String author_book_name) {
		Author_book_name = author_book_name;
	}


	public int getAuthor_total_publications() {
		return Author_total_publications;
	}


	public void setAuthor_total_publications(int author_total_publications) {
		Author_total_publications = author_total_publications;
	}


	public String getAutor_website() {
		return Autor_website;
	}


	public void setAutor_website(String autor_website) {
		Autor_website = autor_website;
	}


	public int getAuthor_is_new() {
		return Author_is_new;
	}


	public void setAuthor_is_new(int author_is_new) {
		Author_is_new = author_is_new;
	}


	@Override
	public String toString() {
		return "Author [Author_id=" + Author_id + ", Author_book_name=" + Author_book_name
				+ ", Author_total_publications=" + Author_total_publications + ", Autor_website=" + Autor_website
				+ ", Author_is_new=" + Author_is_new + "]";
	}

	
	
	
	}
