package br.org.serratec.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.biblioteca.entities.Perfil;
import br.org.serratec.biblioteca.repositories.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	PerfilRepository perfilRepository;

	public List<Perfil> findAll() {
		return perfilRepository.findAll();
	}

	public Perfil findById(Integer id) {
		return perfilRepository.findById(id).orElse(null);
	}

	public Perfil save(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	public Perfil update(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	public Perfil deleteById(Integer id) {
		Perfil perfilDeletado = perfilRepository.findById(id).orElse(null);
		if (perfilDeletado != null) {
			try {
				perfilRepository.deleteById(id);
				return perfilDeletado;
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return perfilDeletado;
	}

	public Perfil deletePerfil(Perfil perfil) {
		Perfil perfilDeletado = perfilRepository.findById(perfil.getPerfilId()).orElse(null);
		if (perfilDeletado != null) {
			try {
				perfilRepository.delete(perfil);
				return perfilDeletado;
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		return perfilDeletado;
	}

	public long count() {
		return perfilRepository.count();
	}
}