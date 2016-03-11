package rolo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq_gen")
	@SequenceGenerator(name = "roles_seq_gen", sequenceName = "rolo.roles_id_seq",allocationSize=1)
	private Integer id;
	private String name;

	//bi-directional many-to-one association to Urro
	@OneToMany(mappedBy="role")
	private List<Urro> urros;

	//------- mine -----------
	public Integer getVersion() {
		return 1;
	}
	public String toString(){
        return id==null?"0":String.valueOf(id);
	}
    //--------------------------

	public Role() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Urro> getUrros() {
		return this.urros;
	}

	public void setUrros(List<Urro> urros) {
		this.urros = urros;
	}

	public Urro addUrro(Urro urro) {
		getUrros().add(urro);
		urro.setRole(this);

		return urro;
	}

	public Urro removeUrro(Urro urro) {
		getUrros().remove(urro);
		urro.setRole(null);

		return urro;
	}

}