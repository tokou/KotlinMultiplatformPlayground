//
//  ViewController.swift
//  KotlinMultiplatformPlayground
//
//  Created by Tarek Belkahia on 15/02/2018.
//  Copyright © 2018 Tarek Belkahia. All rights reserved.
//

import UIKit
import KotlinMultiplatformPlaygroundLib

class ViewController: UIViewController {
    
    @IBOutlet var textView: UITextView?

    override func viewDidLoad() {
        super.viewDidLoad()
        let common = KMPLCommon()
        textView?.text = "\(common.common()) \(common.platform())"
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

