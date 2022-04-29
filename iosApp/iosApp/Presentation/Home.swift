//
//  Home.swift
//  iosApp
//
//  Created by Kashif Mehmood on 26/04/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct Home: View {
    @ObservedObject var viewModel = HomeViewModel()
    @State var currentIndex : Int = 0
    var body: some View {
       
        VStack (spacing: 15){
            Spacer()
            VStack(alignment: .leading, spacing: 12){
                 
                Text("Muslim Scientists").font(.title)
                    .fontWeight(.black)
                
                
            }.frame(maxWidth: .infinity,  alignment: .leading)
                .padding()
            
            Carousel( index: $currentIndex, items: viewModel.list, content: {scientist in
                
               
                GeometryReader{proxy in
                    let size = proxy.size
                    ZStack{
                     
                        
                        AsyncImage(url: URL(string: scientist.image ?? "" ),content: { image in
                            image.resizable()
                                .aspectRatio(contentMode: .fill)
                                .frame(width: size.width)
                                .cornerRadius(10)
                        },
                        placeholder: {
                            ProgressView()
                        } )
                      
                        Text(scientist.name ?? "").frame(width: size.width,height:55, alignment: .center).background(.black).opacity(0.8).foregroundColor(.white).font(.subheadline)
                        
                    } .frame(width: size.width)
                 
                    
                    
                    
                }
                
              
                
            }).padding(.vertical,80)
            
        }.frame(maxHeight: .infinity ,alignment: .top).onAppear {
            viewModel.getAllScientists()
        }
      
        
    }
}


struct Home_Previews: PreviewProvider {
    static var previews: some View {
        Home()
    }
}
