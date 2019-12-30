package mzw.entity;

import java.util.Date;

/*id                   varchar2(36)                    not null,
name                 varchar2(30),
author               varchar2(100),
cover                varchar2(256),
press                varchar2(256),
press_date           date,
edition              varchar2(30),
print_date           date,
impression           varchar2(30),
isbn                 varchar2(20),
word_num             number(12),
page_num             number(12),
sizes                varchar2(12),
paper                varchar2(24),
pack                 varchar2(24),
price                number(10,2),
dprice               number(10,2),
create_date          date,
editor_recommend     varchar2(4000),
content_abstract     varchar2(4000),
author_abstract      varchar2(4000),
directory            varchar2(4000),
media_commentary     varchar2(4000),
category_id          varchar2(36),
sale                 number(20),
stock                number(12),*/
public class Book {
	private String id;//1
	private String name;//2
	private String author;//3
	private String cover;//4
	private String press;//5
	private Date press_date;//6
	private String edition;//7
	private Date print_date;//8
	private String impression;//9
	private String isbn;//10
	private Integer word_num;//11
	private Integer page_num;//12
	private String sizes;//13
	private String paper;//14
	private String pack;//15
	private Double price;//16
	private Double dprice;//17
	private Date create_date;//18
	private String editor_recommend;//19
	private String content_abstract;//20
	private String author_abstract;//21
	private String directory;//22
	private String media_commentary;//23
	private String category_id;//所属类别id  24
	private Integer sale;//25
	private Integer stock;//26
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(String id, String name, String author, String cover,
			String press, Date press_date, String edition, Date print_date,
			String impression, String isbn, Integer word_num, Integer page_num,
			String sizes, String paper, String pack, Double price,
			Double dprice, Date create_date, String editor_recommend,
			String content_abstract, String author_abstract, String directory,
			String media_commentary, String category_id, Integer sale,
			Integer stock) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.cover = cover;
		this.press = press;
		this.press_date = press_date;
		this.edition = edition;
		this.print_date = print_date;
		this.impression = impression;
		this.isbn = isbn;
		this.word_num = word_num;
		this.page_num = page_num;
		this.sizes = sizes;
		this.paper = paper;
		this.pack = pack;
		this.price = price;
		this.dprice = dprice;
		this.create_date = create_date;
		this.editor_recommend = editor_recommend;
		this.content_abstract = content_abstract;
		this.author_abstract = author_abstract;
		this.directory = directory;
		this.media_commentary = media_commentary;
		this.category_id = category_id;
		this.sale = sale;
		this.stock = stock;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Date getPress_date() {
		return press_date;
	}
	public void setPress_date(Date press_date) {
		this.press_date = press_date;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public Date getPrint_date() {
		return print_date;
	}
	public void setPrint_date(Date print_date) {
		this.print_date = print_date;
	}
	public String getImpression() {
		return impression;
	}
	public void setImpression(String impression) {
		this.impression = impression;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Integer getWord_num() {
		return word_num;
	}
	public void setWord_num(Integer word_num) {
		this.word_num = word_num;
	}
	public Integer getPage_num() {
		return page_num;
	}
	public void setPage_num(Integer page_num) {
		this.page_num = page_num;
	}
	public String getSizes() {
		return sizes;
	}
	public void setSizes(String sizes) {
		this.sizes = sizes;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDprice() {
		return dprice;
	}
	public void setDprice(Double dprice) {
		this.dprice = dprice;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getEditor_recommend() {
		return editor_recommend;
	}
	public void setEditor_recommend(String editor_recommend) {
		this.editor_recommend = editor_recommend;
	}
	public String getContent_abstract() {
		return content_abstract;
	}
	public void setContent_abstract(String content_abstract) {
		this.content_abstract = content_abstract;
	}
	public String getAuthor_abstract() {
		return author_abstract;
	}
	public void setAuthor_abstract(String author_abstract) {
		this.author_abstract = author_abstract;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public String getMedia_commentary() {
		return media_commentary;
	}
	public void setMedia_commentary(String media_commentary) {
		this.media_commentary = media_commentary;
	}
	public String getCategory_id() {
		return category_id;
	}
	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}
	public Integer getSale() {
		return sale;
	}
	public void setSale(Integer sale) {
		this.sale = sale;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result
				+ ((author_abstract == null) ? 0 : author_abstract.hashCode());
		result = prime * result
				+ ((category_id == null) ? 0 : category_id.hashCode());
		result = prime
				* result
				+ ((content_abstract == null) ? 0 : content_abstract.hashCode());
		result = prime * result + ((cover == null) ? 0 : cover.hashCode());
		result = prime * result
				+ ((create_date == null) ? 0 : create_date.hashCode());
		result = prime * result
				+ ((directory == null) ? 0 : directory.hashCode());
		result = prime * result + ((dprice == null) ? 0 : dprice.hashCode());
		result = prime * result + ((edition == null) ? 0 : edition.hashCode());
		result = prime
				* result
				+ ((editor_recommend == null) ? 0 : editor_recommend.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((impression == null) ? 0 : impression.hashCode());
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		result = prime
				* result
				+ ((media_commentary == null) ? 0 : media_commentary.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pack == null) ? 0 : pack.hashCode());
		result = prime * result
				+ ((page_num == null) ? 0 : page_num.hashCode());
		result = prime * result + ((paper == null) ? 0 : paper.hashCode());
		result = prime * result + ((press == null) ? 0 : press.hashCode());
		result = prime * result
				+ ((press_date == null) ? 0 : press_date.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((print_date == null) ? 0 : print_date.hashCode());
		result = prime * result + ((sale == null) ? 0 : sale.hashCode());
		result = prime * result + ((sizes == null) ? 0 : sizes.hashCode());
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result
				+ ((word_num == null) ? 0 : word_num.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (author_abstract == null) {
			if (other.author_abstract != null)
				return false;
		} else if (!author_abstract.equals(other.author_abstract))
			return false;
		if (category_id == null) {
			if (other.category_id != null)
				return false;
		} else if (!category_id.equals(other.category_id))
			return false;
		if (content_abstract == null) {
			if (other.content_abstract != null)
				return false;
		} else if (!content_abstract.equals(other.content_abstract))
			return false;
		if (cover == null) {
			if (other.cover != null)
				return false;
		} else if (!cover.equals(other.cover))
			return false;
		if (create_date == null) {
			if (other.create_date != null)
				return false;
		} else if (!create_date.equals(other.create_date))
			return false;
		if (directory == null) {
			if (other.directory != null)
				return false;
		} else if (!directory.equals(other.directory))
			return false;
		if (dprice == null) {
			if (other.dprice != null)
				return false;
		} else if (!dprice.equals(other.dprice))
			return false;
		if (edition == null) {
			if (other.edition != null)
				return false;
		} else if (!edition.equals(other.edition))
			return false;
		if (editor_recommend == null) {
			if (other.editor_recommend != null)
				return false;
		} else if (!editor_recommend.equals(other.editor_recommend))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (impression == null) {
			if (other.impression != null)
				return false;
		} else if (!impression.equals(other.impression))
			return false;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (media_commentary == null) {
			if (other.media_commentary != null)
				return false;
		} else if (!media_commentary.equals(other.media_commentary))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pack == null) {
			if (other.pack != null)
				return false;
		} else if (!pack.equals(other.pack))
			return false;
		if (page_num == null) {
			if (other.page_num != null)
				return false;
		} else if (!page_num.equals(other.page_num))
			return false;
		if (paper == null) {
			if (other.paper != null)
				return false;
		} else if (!paper.equals(other.paper))
			return false;
		if (press == null) {
			if (other.press != null)
				return false;
		} else if (!press.equals(other.press))
			return false;
		if (press_date == null) {
			if (other.press_date != null)
				return false;
		} else if (!press_date.equals(other.press_date))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (print_date == null) {
			if (other.print_date != null)
				return false;
		} else if (!print_date.equals(other.print_date))
			return false;
		if (sale == null) {
			if (other.sale != null)
				return false;
		} else if (!sale.equals(other.sale))
			return false;
		if (sizes == null) {
			if (other.sizes != null)
				return false;
		} else if (!sizes.equals(other.sizes))
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (word_num == null) {
			if (other.word_num != null)
				return false;
		} else if (!word_num.equals(other.word_num))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", author=" + author
				+ ", cover=" + cover + ", press=" + press + ", press_date="
				+ press_date + ", edition=" + edition + ", print_date="
				+ print_date + ", impression=" + impression + ", isbn=" + isbn
				+ ", word_num=" + word_num + ", page_num=" + page_num
				+ ", sizes=" + sizes + ", paper=" + paper + ", pack=" + pack
				+ ", price=" + price + ", dprice=" + dprice + ", create_date="
				+ create_date + ", editor_recommend=" + editor_recommend
				+ ", content_abstract=" + content_abstract
				+ ", author_abstract=" + author_abstract + ", directory="
				+ directory + ", media_commentary=" + media_commentary
				+ ", category_id=" + category_id + ", sale=" + sale
				+ ", stock=" + stock + "]";
	}
}
