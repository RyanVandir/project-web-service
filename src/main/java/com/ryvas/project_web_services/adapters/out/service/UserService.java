package com.ryvas.project_web_services.adapters.out.service;

import com.ryvas.project_web_services.adapters.mapper.UserMapper;
import com.ryvas.project_web_services.adapters.out.entity.UserEntity;
import com.ryvas.project_web_services.adapters.out.repository.UserRepository;
import com.ryvas.project_web_services.domain.exception.DatabaseException;
import com.ryvas.project_web_services.domain.exception.UserNotFoundException;
import com.ryvas.project_web_services.domain.model.User;
import com.ryvas.project_web_services.port.out.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserServicePort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.toModel(userRepository.findAll());
    }

    @Override
    public User deleteById(Integer id) {
        try {
            UserEntity userEntity = userRepository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado!"));
            userRepository.delete(userEntity);
            return userMapper.toModel(userEntity);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Usuário não pode ser removido pois possui vínculos");
        } catch (DataAccessException e) {
            throw new DatabaseException("Erro ao acessar banco de dados");
        }
    }

    @Override
    public Optional<User> findById(Integer id) {
        try {
            return userRepository.findById(id)
                    .map(userMapper::toModel);
        }catch (DataAccessException e) {
            throw new DatabaseException("Erro ao acessar banco de dados");
        }
    }

    @Override
    public User insert(User user) {
        try {
            return userMapper.toModel(userRepository.save(userMapper.toEntity(user)));
        }catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Erro de integridade ao salvar usário");
        } catch (DataAccessException e) {
            throw new DatabaseException("Erro ao acessar banco de dados");
        }
    }

    @Override
    public User update(Integer id, User user) {
        try {
            UserEntity userEntity = userRepository.findById(id)
                    .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado!"));
            userEntity.update(user);
            return userMapper.toModel(userRepository.save(userEntity));
        }catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Erro de integridade ao atualizar usário");
        } catch (DataAccessException e) {
            throw new DatabaseException("Erro ao acessar banco de dados");
        }
    }
}
