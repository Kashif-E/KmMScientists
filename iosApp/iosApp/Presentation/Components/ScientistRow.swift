//
//  ScientistRow.swift
//  iosApp
//
//  Created by Kashif Mehmood on 01/05/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared
struct ScientistRow: View {
    
    var scientist : ScientistDomainModel
    
    init(scientist: ScientistDomainModel){
        
        self.scientist =  scientist
    }
    
    var body: some View {
       
        ZStack{
            RoundedRectangle(cornerRadius: 12, style: .continuous)
                .fill(.white).frame(width: .infinity, height: 210).shadow(radius: 5)
            HStack{
                AsyncImage(url: URL(string: scientist.image ?? ""),
                transaction: Transaction(
                    animation:.default
                )
                ){phase in
                   
                    
                    switch phase{
                        
                    case .success(let image):
                        image.imageModifier()
                    case .failure(_):
                        Image(systemName:"ant.circle.fill")
                            .iconModifier()
                    case .empty:
                        Image(systemName:"photo.circle.fill")
                            .iconModifier()
                        
                    @unknown default:
                       ProgressView()
                    }
                    
                    
                  
                   
                }.frame(  width: 150, height: 190, alignment: .leading).cornerRadius(5).padding()
                
                VStack{
                    
                    Text(scientist.fullName ?? "").foregroundColor(Color.black).foregroundColor(Color.black)
                        .font(.system(size: 18))
                        .fontWeight(.bold)
                        .frame(maxWidth: .infinity, alignment: .leading)
                    Text(scientist.titles ?? "").foregroundColor(Color.black)
                        .font(.system(size: 14))
                        .frame(maxWidth: .infinity, alignment: .leading)
              

                    
 
                
               
            }
           
        }
        }
    }
}

