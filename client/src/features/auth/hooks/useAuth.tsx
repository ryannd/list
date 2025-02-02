import { useContext } from 'react';
import { AuthContext } from '../contexts/AuthProvider';

export default function useFirebaseAuth() {
    const context = useContext(AuthContext);
    if (context === null) {
        throw new Error('useFirebaseAuth must be used within a AuthProvider');
    }
    return context.user;
}
