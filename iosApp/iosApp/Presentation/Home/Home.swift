//
//  Home.swift
//  iosApp
//
//  Created by Kashif Mehmood on 26/04/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct Home: View {
    @ObservedObject var viewModel = HomeViewModel()
    @State var scientist : ScientistDomainModel = ScientistDomainModel()
    @State var shouldNavigate : Bool = false
    
    var body: some View {
       
        VStack (spacing: 15){
            Spacer()
            VStack(alignment: .leading, spacing: 12){
                 
                Text("Muslim Scientists").font(.title)
                    .fontWeight(.bold).foregroundColor(.green)
                
                
            }.frame(maxWidth: .infinity,  alignment: .leading)
                .padding()
            
          
            
           
                        List {
                            ForEach(viewModel.list, id: \.id ) { index in
                               
                                ScientistRow(scientist: index).onTapGesture {
                                    scientist = index
                                    shouldNavigate = true
                                }
                                
                            }
                        }.frame( maxWidth: .infinity)
                .edgesIgnoringSafeArea(.all)
                .listStyle(PlainListStyle())
                    
            
            
            
            
            
        }.frame(maxHeight: .infinity ,alignment: .top).onAppear {
            viewModel.getAllScientists()
        }.navigate(to: ScientistDetails(scientist: scientist), when: $shouldNavigate, title : "Home", bar: false)
      
        
    }
}


//struct Home_Previews: PreviewProvider {
//    static var previews: some View {
//      //  Home()
//    }
//}
