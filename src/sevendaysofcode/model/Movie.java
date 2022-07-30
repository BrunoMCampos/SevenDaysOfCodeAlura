package sevendaysofcode.model;

public class Movie {

	private String title;
	private String urlImage;
	private Double rating;
	private Integer year;

	public Movie(String title, String urlImage, Double rating, Integer year) {
		super();
		this.title = title;
		this.urlImage = urlImage;
		this.rating = rating;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public Double getRating() {
		return rating;
	}

	public Integer getYear() {
		return year;
	}

	@Override
	public String toString() {
		return "Movie: " + title + " (" + year + ") - Rating:" + rating + " -- Image:" + urlImage;
	}

}
