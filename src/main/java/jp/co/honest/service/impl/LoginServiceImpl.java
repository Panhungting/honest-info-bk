package jp.co.honest.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.honest.domain.Employee;
import jp.co.honest.repository.EmployeeRepository;
import jp.co.honest.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Employee> getLoginUser(String loginId, String password) {
        return employeeRepository.selectByLoginIdAndPassword(loginId, password);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getEmployeeIsExist(String loginId) {
        return employeeRepository.selectEmployeeCountByLoginId(loginId);
    }
}