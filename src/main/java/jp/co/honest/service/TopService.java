package jp.co.honest.service;

import java.util.List;

import jp.co.honest.domain.Bulletin;

/*
 * 掲示板に関するサービスを提供するクラス
 */
public interface TopService {

    /**
     * すべての掲示板を取得
     *
     * @return 掲示板リスト
     */
    List<Bulletin> getBulletinList();
}