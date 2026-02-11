package practice.beans;

//DTO
//- Data Transfer Object
//- 데이터 변환 객체
//- 포장 상자처럼 낱개의 데이터를 의미있게 모아서 보관하는 역할
//- 이 클래스는 데이터베이스와 동일한 이름과 항목으로 구성
//- 필드만 직접 생성하고 나머지(setter,getter,생성자,toString)는 자동생성
public class PokemonDto {
	private int pokemonNo;
	private String pokemonName;
	private String pokemonType;
	@Override
	public String toString() {
		return "PokemonDto [pokemonNo=" + pokemonNo + ", pokemonName=" + pokemonName + ", pokemonType=" + pokemonType
				+ "]";
	}
	public PokemonDto() {
		super();
	}
	public int getPokemonNo() {
		return pokemonNo;
	}
	public void setPokemonNo(int pokemonNo) {
		this.pokemonNo = pokemonNo;
	}
	public String getPokemonName() {
		return pokemonName;
	}
	public void setPokemonName(String pokemonName) {
		this.pokemonName = pokemonName;
	}
	public String getPokemonType() {
		return pokemonType;
	}
	public void setPokemonType(String pokemonType) {
		this.pokemonType = pokemonType;
	}
}
