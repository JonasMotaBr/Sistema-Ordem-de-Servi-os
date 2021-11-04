package beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.dao.DaoGeneric;
import br.com.jsf.entity.UsuarioEntity;

@ManagedBean(name = "usuarioBean")
public class UsuarioBean {

	private UsuarioEntity usua = new UsuarioEntity();
	private DaoGeneric<UsuarioEntity> dao = new DaoGeneric<UsuarioEntity>();
	private List<UsuarioEntity> lista = new ArrayList<UsuarioEntity>();
	
	
	
	public String salvar() {
		dao.salvar(usua);
		return "";
	}
	

	
	public UsuarioEntity getUsua() {
		return usua;
	}
	public void setUsua(UsuarioEntity usua) {
		this.usua = usua;
	}



	public List<UsuarioEntity> getLista() {
		lista = dao.getListEntity(UsuarioEntity.class);
		return lista;
	}



	
	
	
	
	
	
}
