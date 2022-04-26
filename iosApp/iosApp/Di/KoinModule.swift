//
//  KoinModule.swift
//  iosApp
//
//  Created by Kashif Mehmood on 26/04/2022.
//  Copyright © 2022 orgName. All rights reserved.
//


import SwiftUI
import shared

func startKoin() {
   

    _koin = KoinModuleKt.doInitKoin().koin
}

private var _koin: Koin_coreKoin?

var koin: Koin_coreKoin {
    return _koin!
}


extension Koin_coreKoin {

 
    func get() ->  GetAllScientistUseCase{
        return koin.getDependency(objCClass: GetAllScientistUseCase.self) as! GetAllScientistUseCase
        
    }

    func get()-> GetScientistsByOriginUseCase{
        return koin.getDependency(objCClass: GetScientistsByOriginUseCase.self) as!   GetScientistsByOriginUseCase
    }

 

}

