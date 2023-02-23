package service;

import java.util.List;

import entity.Family;

public interface FamilyService {
    List< Family > listFamiliesOrdered ( List< Family > families );
}
