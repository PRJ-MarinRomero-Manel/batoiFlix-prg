package es.progcipfpbatoi.batoiflix_prg.model.entities;

public enum Plataforma {
	HBO,RAKUTEN,APPLE, AMAZON, NETFLIX, DISNEY ,POPCORNFLIX;
	
	@Override
	public String toString() {
		switch(this) {
		case RAKUTEN: return "RAKUTEN TV";
		case APPLE: return "APPLE TV+";
		case AMAZON: return "AMAZON PRIME VIDEO";
		case DISNEY: return "DISNEY +";
		default: return name();
		}
	}
}
