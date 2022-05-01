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
            
          
            
            ScrollView(.horizontal) {
                        LazyHStack {
                            ForEach(viewModel.list, id: \.id ) { index in
                                Text(index.name ?? "")
                                    .onAppear {
                                        print(index)
                                    }
                            }
                        }
                    }
            
            
            
            
            
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
