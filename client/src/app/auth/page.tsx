'use client'

import { signInWithGoogle } from "../../lib/firebase/auth";

export default function Auth() {

    const handleSignIn = async () => {
        await signInWithGoogle();
    }   

    return <>
        <button onClick={handleSignIn}>
            Sign in with Google
        </button>
    </>

}