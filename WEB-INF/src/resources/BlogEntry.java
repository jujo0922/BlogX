package resources;

import java.time.LocalDate;
import java.util.Objects;

public class BlogEntry {
    private String id;
    private String titulo;
    private String imagen;
    private String texto;
    private LocalDate fecha;

    public BlogEntry(){
        id = "1";
        titulo = "1";
        imagen = "1";
        texto = "1";
        fecha = LocalDate.now();
    }
    public BlogEntry(String id,String titulo,String imagen,String texto, LocalDate fecha){
        this.id = id;
        this.titulo = titulo;
        this.imagen = imagen;
        this.texto = texto;
        this.fecha = fecha;
    }
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
            BlogEntry other = (BlogEntry) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "BlogEntry [id=" + id + ", titulo=" + titulo + ", imagen=" + imagen + ", texto=" + texto + ", fecha=" + fecha
				+ "]";
	}



}
