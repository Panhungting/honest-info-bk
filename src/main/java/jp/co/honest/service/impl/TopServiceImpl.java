package jp.co.honest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.honest.domain.Bulletin;
import jp.co.honest.repository.BulletinRepository;
import jp.co.honest.service.TopService;

@Service
@Transactional
public class TopServiceImpl implements TopService {

    @Autowired
    private BulletinRepository bullertnRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Bulletin> getBulletinList() {
        return bullertnRepository.selectPubished();
    }
}