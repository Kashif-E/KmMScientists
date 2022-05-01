//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Kashif Mehmood on 26/04/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

class HomeViewModel : ObservableObject{
    
   @Published var list : [ScientistDomainModel] = []
    
    private let getAllScientistUseCase: GetAllScientistUseCase = koin.get()
    
    private let getScientistByOriginUseCase : GetScientistsByOriginUseCase = koin.get()
    
    func getAllScientists(){
        
        getAllScientistUseCase.invoke().collectCommon(coroutineScope:nil,collect:{ dataState in
            
            
            switch (dataState){
                
                //Success State
            case is DataStateSuccess<NSArray>:
                
                let data = dataState?.data as! [ScientistDomainModel]
               
                self.list = data
                
                //Error case
            case is DataStateError<NSArray>:
                
              print("error")
                
                
                
                //Default
                
            default:
                
                print("default")
                
                
            }
            
            
        }, error: {DataStateMessage  in
            
        })
        
      
        
    }
}
