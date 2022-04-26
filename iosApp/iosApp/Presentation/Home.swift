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
    var body: some View {
        VStack{
            Text("x").onTapGesture {
                viewModel.getAllScientists()
            }
            List{
                
                ForEach(viewModel.list , id: \.id){ item in
                               
                    Text(item.name ?? "")
                }

            }
        }
        
    }
}

struct Home_Previews: PreviewProvider {
    static var previews: some View {
        Home()
    }
}
