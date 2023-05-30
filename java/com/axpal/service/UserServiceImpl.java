package com.axpal.service;
import com.axpal.converter.AxpalCommonConverter;
import com.axpal.dto.UserModel;
import com.axpal.entity.AxpalUserEntity;
import com.axpal.exception.*;
import com.axpal.exception.model.AxpalUtilException;
import com.axpal.model.UserQueryModel;
import com.axpal.query.UserQueryGenerator;
import org.springframework.transaction.annotation.Transactional;
import com.axpal.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserQueryGenerator queryGenerator;

    @Override
    public UserModel userSave(UserModel model) throws SaveException, SingleRecordError {
        try {
           AxpalUserEntity entity = userRepository.saveAndFlush(AxpalCommonConverter.convert(model, AxpalUserEntity.class));
           return AxpalCommonConverter.convert(entity, UserModel.class);
       } catch (DataIntegrityViolationException e) {
           throw new AxpalUtilException(e, UserService.class);
       } catch (Exception e) {
            throw new AxpalUtilException(e, UserService.class);
       }
    }

    @Override
    public UserModel userUpdate(UserModel model) throws UpdateException {
        try {
            AxpalUserEntity entity = userRepository.updateAndFlush(AxpalCommonConverter.convert(model, AxpalUserEntity.class));
           return AxpalCommonConverter.convert(entity, UserModel.class);
       } catch (DataIntegrityViolationException e) {
            throw new AxpalUtilException(e, UserService.class);
        } catch (Exception e) {
            throw new AxpalUtilException(e, UserService.class);
        }
   }

    @Override
    public void userDelete(Long id) throws DeleteException {
       try {
           userRepository.deleteById(id);
      } catch (Exception e) {
            throw new AxpalUtilException(e, UserService.class);
        }
   }

    @Override
    public List<UserModel> getUserList(UserQueryModel queryModel) throws GetException {
        return null;
    }


//    @Override
//    @Transactional(readOnly = true)
//    public List<UserModel> getUserList(UserQueryModel queryModel) throws GetException {
//        try {
//            List<AxpalUserEntity> result = userRepository.findAll(queryGenerator.generate(queryModel, UserQueryGenerator.));
//            return AxpalCommonConverter.convert(result, new TypeReference<List<IlacTanimModel>>() {
//           });
//        } catch (Exception e) {
//            throw new EczaUtilException(e, IlacTanimService.class);
//       }
//    }

    @Override
    public UserModel getUser(Long id) throws GetException, KontrolException {
        return null;
    }
}
