package br.org.serratec.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.serratec.biblioteca.entities.Usuario;
import br.org.serratec.biblioteca.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findById(Integer id) { 
		return usuarioRepository.findById(id).orElse(null); 
	}

	public Usuario save(Usuario usuario) { 
		return usuarioRepository.save(usuario);
	}

	public Usuario update(Usuario usuario) { 
		return usuarioRepository.save(usuario);
	}

	public Usuario deleteById(Integer id) {
		Usuario usuarioDeletado = usuarioRepository.findById(id).orElse(null);
		if(usuarioDeletado != null) {
			try {
				usuarioRepository.deleteById(id);
				return usuarioDeletado;
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		return usuarioDeletado;
	}
	
	public Usuario deleteUsuario(Usuario usuario) {
		Usuario usuarioDeletado = usuarioRepository.findById(usuario.getUser_id()).orElse(null);
		if(usuarioDeletado != null) {
			try {
				usuarioRepository.delete(usuario);
				return usuarioDeletado;
			} catch(Exception e) {
				System.out.println(e);
			}
		}
		return usuarioDeletado;
	}
}
