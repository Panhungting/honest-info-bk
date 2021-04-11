package jp.co.honest.service;

import java.util.Optional;

import jp.co.honest.domain.Employee;

/*
 * ログインに関するサービスを提供するクラス
 */
public interface LoginService {
    

    /**
     * ログイン情報を取得
     *
     * @return ログインユーザ
     */
    Optional<Employee> getLoginUser(String loginId, String password);

    /**
     * ログインID存在確認
     * 
     * @return Count
     */
    int getEmployeeIsExist(String logId);
}